package base.servlets;

import base.daos.Dao;
import base.services.MongoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class LoginServlet extends HttpServlet {
    private Dao dao;
    private MongoService service;

    public LoginServlet() {}
    public LoginServlet(Dao dao, MongoService service) {
        this.dao = dao;
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("************************");
        System.out.println("Inside LoginServlet doGet()");

    }
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("service() for LoginServlet");

        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()){
            String paramName = params.nextElement();
            System.out.println("Parameter Name - "+paramName+", Value - "+req.getParameter(paramName));
        }
//
//        String empID = req.getParameter("empID");
//        String password = req.getParameter("password");
//        System.out.println("empID is: " + empID);
//        System.out.println("password is: " + password);
//        doPost(req, res);
        res.setStatus(500);
    }

    @Override
    public void destroy() {
        System.out.println("destroy() LoginServlet");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init() LoginServlet");


    }
}
