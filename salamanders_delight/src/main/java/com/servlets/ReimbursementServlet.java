package com.servlets;

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
import java.util.ArrayList;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {
    private MongoReimbursementService service;

    public void setService(MongoReimbursementService service) {
        this.service = service;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        MongoConnector connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        Dao dao = new MongoDao(connector);
        service = new MongoReimbursementService(dao);
        System.out.println("Inside ReimbursementServlet doGet");
        //Get the empID param from the request url.
        String empID = req.getParameter("userID");
        List<ReimbursementRequest> list = new ArrayList<>();
        FindIterable<ReimbursementRequest> allRequests = service.getAllRequestsByEmpID(empID);
        if (allRequests.first() != null) {
            for (ReimbursementRequest request : allRequests) {
                request.setCustomId(request.getId().toString());
                list.add(request);
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        System.out.println("json");
        System.out.println(json);
        res.setStatus(200);
        PrintWriter resWriter = res.getWriter();
        resWriter.print(json);
    }
}
