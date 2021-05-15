package com.servlets;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.Employee;
import com.pojos.ReimbursementRequest;
import com.services.MongoReimbursementService;
import com.services.MongoService;
import com.services.MongoUserService;
import com.utils.MongoConnector;
import com.utils.ProfileUpdater;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class UpdateEmpProfileServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoService<Employee> service;
    private Controller controller;
    private ObjectMapper mapper;
    private BufferedReader bodyReader;
    private String bodyString;
    private ProfileUpdater profileUpdate;
    private int responseStatus;
    private String nextURL;
    private PrintWriter responseWriter;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PUT in UpdateEmpProfileServlet");
        //get body
        bodyReader = req.getReader();
        bodyString = bodyReader.lines().collect(Collectors.joining());
        System.out.println("bodyString: " + bodyString);
        mapper = new ObjectMapper();
        profileUpdate = mapper.readValue(bodyString, ProfileUpdater.class);
        controller.updateOneEmployeeField(profileUpdate.getUserID(), profileUpdate.getField(), profileUpdate.getValue());

    }

    @Override
    public void init() throws ServletException {
        connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        dao = new MongoDao(connector);
        service = new MongoUserService(dao);
        controller = new ReactController(service);
    }
}
