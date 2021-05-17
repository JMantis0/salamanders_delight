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
import java.util.stream.Collectors;
public class CreateReimbursementServlet extends HttpServlet {
    private Controller controller;
    @Override
    public void init() throws ServletException {
        MongoConnector connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        Dao dao = new MongoDao(connector);
        MongoReimbursementService service = new MongoReimbursementService(dao);
        controller = new ReactController(service);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Inside doPost CreateReimbursementServlet");
        BufferedReader bodyReader = req.getReader();
        String bodyString = bodyReader.lines().collect(Collectors.joining());
        ObjectMapper mapper = new ObjectMapper();
        ReimbursementRequest newRequest = mapper.readValue(bodyString, ReimbursementRequest.class);
        controller.createRequest(newRequest);
        System.out.println("Is there a new request?");
        res.setStatus(201);
    }
}
