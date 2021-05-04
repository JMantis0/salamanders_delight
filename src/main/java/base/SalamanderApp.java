package base;

import base.daos.Dao;
import base.daos.MongoDao;
import base.pojos.Employee;
import base.pages.HomePage;
import base.pages.Page;
import base.services.MongoEmployeeService;
import base.services.MongoService;
import base.utils.ConsolePrinter;
import base.utils.ContextClearer;
import base.utils.KeyboardReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SalamanderApp extends AbstractApp {
    private Page currentPage;
    protected MongoConnector connector;
    org.apache.logging.log4j.Logger rootLogger = LogManager.getRootLogger();
    private static Logger logger = LogManager.getLogger();

    public SalamanderApp(String title, MongoConnector connector) {
        this.title = title;
        this.connector = connector;
        this.currentPage = new HomePage();
    }

    @Override
    protected void run(Map<String, Object> context) {
        context = new HashMap<String, Object>();
        Dao dao = new MongoDao(connector);
        MongoService<Employee> es = new MongoEmployeeService(dao);
        KeyboardReader kr = new KeyboardReader(System.in);
        ConsolePrinter cp = new ConsolePrinter(System.out);
        ContextClearer cc = new ContextClearer();
        context.put("Logger", logger);
        context.put("Dao", dao);
        context.put("KeyboardReader", kr);
        context.put("ConsolePrinter", cp);
        context.put("EmployeeService", es);
        context.put("ContextClearer", cc);
        while(currentPage != null) {
            currentPage = currentPage.doPage(context);
        }
    }
}
