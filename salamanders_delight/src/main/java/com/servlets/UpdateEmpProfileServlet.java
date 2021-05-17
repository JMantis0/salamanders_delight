package com.servlets;
import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.pojos.Employee;
import com.services.MongoService;
import com.services.MongoUserService;
import com.utils.MongoConnector;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class UpdateEmpProfileServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoService<Employee> service;
    private Controller controller;
    private BufferedReader bodyReader;
    private String bodyString;

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("PUT in UpdateEmpProfileServlet");
        bodyReader = req.getReader();
        bodyString = bodyReader.lines().collect(Collectors.joining());
        JSONObject jsonBody = new JSONObject(bodyString);
        controller.updateOneEmployeeField(jsonBody.getString("userID"), jsonBody.getString("field"), jsonBody.getString("value"));
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
