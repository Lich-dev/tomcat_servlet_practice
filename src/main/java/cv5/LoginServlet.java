package cv5;

import cv4.User;
import cv4.UserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static cv4.RegistrationServlet.REG_EX_EMAIL;
import static cv4.RegistrationServlet.REG_EX_PASSWORD;

@WebServlet(name = "Login Servlet",value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Set refresh, autoload time as n seconds
        // (It refreshes the browser every second)
        //response.setIntHeader("Refresh", 1);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head><meta charset=\"UTF-8\"><title>");
        // Browser bookmark title
        out.println("Login");
        out.println("</title></head><body>");

        // Add a page body
        out.println("<h1>" + "Login Result" + "</h1>");

        String email = request.getParameter("email");
        String password = request.getParameter("password1");

        User user = UserStorage.loginUser(email, password);
        if (user != null){
            out.println("<h4>Welcome "+user.getFullName()+"</h4>");
        }else {
            out.println("<h4>incorrect password or email!</h4>");
        }

        out.println("<a href=\"index.html\">Domů</a>");

        // End of HTML page
        out.println("</body></html>");
        // Close stream object
        out.close();
    }
}
