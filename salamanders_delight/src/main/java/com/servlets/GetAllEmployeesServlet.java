package com.servlets;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.pojos.Employee;
import com.pojos.ReimbursementRequest;
import com.services.MongoReimbursementService;
import com.services.MongoService;
import com.services.MongoUserService;
import com.utils.MongoConnector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetAllEmployeesServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoService service;
    private Controller controller;
    private ObjectMapper mapper;


    @Override
    public void init() throws ServletException {
        connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        dao = new MongoDao(connector);
        service = new MongoUserService(dao);
        controller = new ReactController(service);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            System.out.println("GetAllEmployeesServlet");
            List<Employee> list = controller.getAllEmployees();
            mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            res.setStatus(200);
            PrintWriter resWriter = res.getWriter();
            resWriter.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
