package com.servlets;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.ReimbursementRequest;
import com.services.MongoReimbursementService;
import com.utils.MongoConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class CreateReimbursementServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoReimbursementService service;
    private Controller controller;
    private ObjectMapper mapper;
    private BufferedReader bodyReader;
    private String bodyString;
    private ReimbursementRequest newRequest;
    private int responseStatus;
    private String nextURL;
    private PrintWriter responseWriter;

    @Override
    public void init() throws ServletException {
        connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        dao = new MongoDao(connector);
        service = new MongoReimbursementService(dao);
        controller = new ReactController(service);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside doPost CreateReimbursementServlet");
        bodyReader = req.getReader();
        bodyString = bodyReader.lines().collect(Collectors.joining());
        mapper = new ObjectMapper();
        newRequest = mapper.readValue(bodyString, ReimbursementRequest.class);
        controller.createRequest(newRequest);
        System.out.println("Is there a new request?");


    }
}
