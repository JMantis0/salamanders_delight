package com.servlets;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.ReimbursementRequest;
import com.services.MongoReimbursementService;
import com.services.MongoUserService;
import com.utils.MongoConnector;
import com.pojos.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class GetCurrentUserServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoUserService service;
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
        service = new MongoUserService(dao);
        controller = new ReactController(service);
    }

    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Inside GetCurrentUserServlet");
        String empID = req.getParameter("empID");
        Employee emp = controller.getCurrentUserProfile(empID);
        System.out.println("GetCurrentUserServlet emp = " + emp);
        mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
        res.setStatus(200);
        res.getWriter().print(json);
    }


}