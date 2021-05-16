package com.servlets;

import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojos.ReimbursementRequest;
import com.services.MongoReimbursementService;
import com.services.MongoService;
import com.utils.MongoConnector;
import org.bson.types.ObjectId;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

public class ResolveRequestServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoService<ReimbursementRequest> service;
    private Controller controller;
    private ObjectMapper mapper;
    private BufferedReader bodyReader;
    private String bodyString;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            System.out.println("In ResolveRequestServlet");
            bodyReader = req.getReader();
            bodyString = bodyReader.lines().collect(Collectors.joining());
            JSONObject jsonBody = new JSONObject(bodyString);
            System.out.println(jsonBody);
            String objectId = jsonBody.getString("objectId");
            String resolver = jsonBody.getString("resolver");
            String resolution = jsonBody.getString("resolution");
            ObjectId objId = new ObjectId(objectId);
            controller.resolveRequest(objId, resolver, resolution);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        dao = new MongoDao(connector);
        service = new MongoReimbursementService(dao);
        controller = new ReactController(service);
    }
}
