package com.servlets;

import com.services.MongoUserService;
import com.utils.MongoConnector;
import com.controllers.Controller;
import com.controllers.ReactController;
import com.daos.Dao;
import com.daos.MongoDao;
import com.services.MongoService;
import javafx.util.Pair;

import org.apache.logging.log4j.LogManager;
import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * <h1>LoginServlet</h1>
 * <h2>Handles client POSTs on path {@code /api/attempt_login}</h2>
 * <p>Extends the HttpServlet interface to provide a specific implementation for doPost </p>
 */
public class LoginServlet extends HttpServlet {
    private Controller controller;
    org.apache.logging.log4j.Logger rootLogger = LogManager.getRootLogger();
    private static org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    Logger mongoLogger = Logger.getLogger("org.mongodb.driver");


    /**
     * * Creates and configures a MongoConnector, and uses it to initialize a chain of MVC Objects:
     * * <ul><li>MongoDao</li><li>MongoEmployeeService</li><li>ReactController</li></ul>
     * * as well as an ObjectMapper to be used by doPost().
     * Reads the empID and password provided by the client request and determines whether the user exists
     * and then whether the password provided by the client is the next password.  Then returns the appropriate
     * url and status code.
     *
     * @param req an HttpServletRequest object with a JSON body with an empID String and password String.
     * @param res an HttpServletResponse object with a Status Code and URL String payload.
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        mongoLogger.setLevel(Level.FATAL);
        MongoConnector connector = new MongoConnector();
        connector.configureCodecAndRegistryAndCreateClient();
        Dao dao = new MongoDao(connector);
        MongoService service = new MongoUserService(dao);
        controller = new ReactController(service);
        System.out.println("Inside LoginServlet doPost");
        //  Get data from the request object to create a PasswordChecker object
        BufferedReader bodyReader = req.getReader();
        String bodyString = bodyReader.lines().collect(Collectors.joining());
        JSONObject jsonBody = new JSONObject(bodyString);
        Pair<String, Integer> nextURLandStatus = controller.loginAttemptAndGetNextURL(jsonBody.getString("userID"), jsonBody.getString("password"), jsonBody.getString("loginType"));
        rootLogger.info("User: " +jsonBody.getString("userID") +  " of type " +  jsonBody.getString("loginType") + "logged in");
        String nextURL = nextURLandStatus.getKey();
        int responseStatus = nextURLandStatus.getValue();
        //  Configure the response object and set the response status
        res.setContentType("text/plain");
        res.setStatus(responseStatus);
        //  Write the nextURL string and send response to client
        PrintWriter responseWriter = res.getWriter();
        responseWriter.print(nextURL);
    }


}
