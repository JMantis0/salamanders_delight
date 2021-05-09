package com.servlets;

import com.utils.MongoConnector;
import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.services.MongoEmployeeService;
import com.services.MongoService;
import com.utils.PasswordChecker;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.util.Pair;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * <h1>LoginServlet</h1>
 * <h2>Handles client POSTs on path {@code /api/attempt_login}</h2>
 * <p>Extends the HttpServlet interface to provide a specific implementation for doPost </p>
 */
public class LoginServlet extends HttpServlet {
    private MongoConnector connector;
    private Dao dao;
    private MongoEmployeeService service;
    private Controller controller;
    private ObjectMapper mapper;
    private BufferedReader bodyReader;
    private String bodyString;
    private PasswordChecker passwordChecker;
    private Pair<String, Integer> nextURLandStatus;
    private int responseStatus;
    private String nextURL;
    private PrintWriter responseWriter;
    /**
     * Creates and configures a MongoConnector, and uses it to initialize a chain of MVC Objects:
     * <ul><li>MongoDao</li><li>MongoEmployeeService</li><li>ReactController</li></ul>
     * as well as an ObjectMapper to be used by doPost().
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        dao = new MongoDao(connector);
        service = new MongoEmployeeService(dao);
        controller = new ReactController(service);
    }
    /**
     * Reads the empID and password provided by the client request and determines whether the user exists
     * and then whether the password provided by the client is the next password.  Then returns the appropriate
     * url and status code.
     * @param req an HttpServletRequest object with a JSON body with an empID String and password String.
     * @param res an HttpServletResponse object with a Status Code and URL String payload.
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Inside doPost");
        //  Get data from the request object to create a PasswordChecker object
        bodyReader = req.getReader();
        bodyString = bodyReader.lines().collect(Collectors.joining());
        mapper = new ObjectMapper();
        passwordChecker = mapper.readValue(bodyString, PasswordChecker.class);
        //  Use PasswordChecker object's field values to call the controller and set the response status/nexturl
        nextURLandStatus = controller.loginAttemptAndGetNextURL(passwordChecker.getEmpID(), passwordChecker.getPassword());
        nextURL = nextURLandStatus.getKey();
        responseStatus = nextURLandStatus.getValue();
        //  Configure the response object and set the response status
        res.setContentType("text/plain");
        res.setStatus(responseStatus);
        //  Write the nextURL string and send response to client
        responseWriter = res.getWriter();
        responseWriter.print(nextURL);
    }
}
