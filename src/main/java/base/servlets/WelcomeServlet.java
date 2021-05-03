package base.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {




    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("This will be called for every single request (service(req, res))");
    }

    @Override
    public void destroy() {
        System.out.println("This will be called eventually (destroy())");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("This will be called only once.  To initialize the servlet");

    }
}
