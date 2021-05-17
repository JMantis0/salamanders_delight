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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetAllReimbursementsServlet extends HttpServlet {
    private MongoReimbursementService service;
    private Controller controller;

    public void setService(MongoReimbursementService service) {
        this.service = service;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MongoConnector connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        Dao dao = new MongoDao(connector);
        service = new MongoReimbursementService(dao);
        controller = new ReactController(service);
        try {
            System.out.println("GetAllReimbursementsServlet");
            List<ReimbursementRequest> list = controller.getAllRequests();
            if (list.size() > 0) {
                for (ReimbursementRequest request : list) {
                    request.setCustomId(request.getId().toString());
                }
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            res.setStatus(200);
            PrintWriter resWriter = res.getWriter();
            if (resWriter != null) {
                resWriter.print(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
