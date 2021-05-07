package base.servlets;

import base.MongoConnector;
import base.controllers.Controller;
import base.daos.Dao;
import base.daos.MongoDao;
import base.services.MongoEmployeeService;
import base.services.MongoService;
import base.utils.PasswordChecker;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClientSettings;
import javafx.util.Pair;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {
    private Dao dao;
    private MongoService service;
    private Controller controller;
    private ObjectMapper mapper;
    private int responseStatus;
    private String nextURL;
    private PrintWriter responseWriter;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Inside doPost");
        //  Get data from the request object to create a PasswordChecker object
        BufferedReader bodyReader = req.getReader();
        String bodyString = bodyReader.lines().collect(Collectors.joining());
        PasswordChecker pc = mapper.readValue(bodyString, PasswordChecker.class);
        //  Use PasswordChecker object's field values to call the controller and set the response status/nexturl
        Pair<String, Integer> nextURLandStatus = controller.loginAttemptAndGetNextURL(pc.getEmpID(), pc.getPassword());
        nextURL = nextURLandStatus.getKey();
        responseStatus = nextURLandStatus.getValue();
        //  Configure the response object and set the response status
        res.setContentType("text/plain");
        res.setStatus(responseStatus);
        //  Write the nextURL string and send response to client
        responseWriter = res.getWriter();
        responseWriter.print(nextURL);

    }

    @Override
    public void init() throws ServletException {
        MongoConnector connector = new MongoConnector();
        connector.configure( () -> {
            CodecProvider codecProvider = PojoCodecProvider.builder().register("base.pojos").build();
            CodecRegistry registry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(codecProvider));
            return MongoClientSettings.builder()
                    .applyConnectionString(connector.newConnectionString("mongodb://localhost:27017/salamander"))
                    .retryWrites(true)
                    .codecRegistry(registry)
                    .build();
        }).createClient();
        dao = new MongoDao(connector);
        service = new MongoEmployeeService(dao);
        controller = new Controller(service);
        mapper = new ObjectMapper();
    }
}
