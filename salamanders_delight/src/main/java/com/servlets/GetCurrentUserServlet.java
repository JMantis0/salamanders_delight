package com.servlets;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.Manager;
import com.pojos.ReimbursementRequest;
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
        String userID = req.getParameter("userID");
        String loginType = req.getParameter("loginType");
        mapper = new ObjectMapper();
        String json;
        switch(loginType) {
            case "employee":
                Employee emp = controller.getCurrentEmployeeProfile(userID);
                System.out.println("GetCurrentUserServlet emp = " + emp);
                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
                break;
            case "manager":
                Manager mgr = controller.getCurrentManagerProfile(userID);
                System.out.println("GetCurrentUserServlet mgr= " + mgr);
                json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mgr);
                break;
            default:
                json = "";
        }
                System.out.println(json);
        res.setStatus(200);
        res.getWriter().print(json);
    }
}