package com.servlets;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
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
import java.util.ArrayList;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoReimbursementService service;
    private Controller controller;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        dao = new MongoDao(connector);
        service = new MongoReimbursementService(dao);
        controller = new ReactController(service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Inside ReimbursementServlet doGet");
        //Get the empID param from the request url.
        String empID = req.getParameter("userID");
        FindIterable<ReimbursementRequest> allRequests = service.getAllRequestsByEmpID(empID);
        List<ReimbursementRequest> list = new ArrayList<>();
        for(ReimbursementRequest request: allRequests) {
            list.add(request);
        }
        mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        res.setStatus(200);
        PrintWriter resWriter = res.getWriter();
        resWriter.print(json);
    }
}
