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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int responseStatus;
        int responseData;
        PrintWriter responseWriter = res.getWriter();
        System.out.println("************************");
        System.out.println("Inside doPost");
        BufferedReader bodyReader = req.getReader();
        String bodyString = bodyReader.lines().collect(Collectors.joining());
        mapper = new ObjectMapper();
        PasswordChecker pc = mapper.readValue(bodyString, PasswordChecker.class);
        System.out.println(controller.loginAttemptAndGetNextURL(pc.getEmpID(), pc.getPassword()));

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
    }
}
