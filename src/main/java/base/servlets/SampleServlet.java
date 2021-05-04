package base.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SampleServlet extends HttpServlet {

    private Integer Integer;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("request" + request);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String languages[] = request.getParameterValues("language");


        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();
        out.println("Your details:");
        out.println("Name: " + name);
        out.println("Age: "+ age);
        out.println("Gender: "+ gender);
        if (languages != null) {
            out.println("Languages are: ");
            for (String lang : languages) {
                out.println(lang);
            }
        }
    }
}