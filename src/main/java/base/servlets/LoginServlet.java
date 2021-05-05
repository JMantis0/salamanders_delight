package base.servlets;

import base.MongoConnector;
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
import java.util.stream.Collectors;

public class LoginServlet extends HttpServlet {
    private Dao dao;
    private MongoService service;
    private ObjectMapper mapper;
    String test;

    public LoginServlet() {}
    public LoginServlet(Dao dao, MongoService service) {
        this.dao = dao;
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("************************");
        System.out.println("Inside LoginServlet doGet()");

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("************************");
        System.out.println("Inside doPost");
        System.out.println("create body reader");
        BufferedReader bodyReader = req.getReader();
        String bodyString = bodyReader.lines().collect(Collectors.joining());
        System.out.println("Attempting to display bodyString UPDATE");
        System.out.println(bodyString);
        mapper = new ObjectMapper();
        System.out.println(mapper.toString());
        PasswordChecker pc = mapper.readValue(bodyString, PasswordChecker.class);
        System.out.println(pc.toString());
        System.out.println("passwordCheckerObject gets: ");
        System.out.println(pc.getEmpID());
        System.out.println(pc.getPassword());
        //  Cool, we've got the strings!!! Holy god yes.  Now call the service method and access the dao.
        System.out.println("Checking to see if the pw is valid");
        boolean isPasswordValid = service.isPasswordValid(pc.getEmpID(), pc.getPassword());
        System.out.println(isPasswordValid);


    }
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("************************");
        System.out.println("service() for LoginServlet");
        System.out.println(test);
        super.service(req, res);
    }

    @Override
    public void destroy() {
        System.out.println("************************");
        System.out.println("destroy() LoginServlet");
    }

    @Override
    public void init() throws ServletException {
        test = "This is a test.  Does this print in service?";
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
    }
}
