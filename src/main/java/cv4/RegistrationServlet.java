package cv4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

@WebServlet(name = "Registration Servlet",value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {
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
        out.println("Registration");
        out.println("</title></head><body>");

        // Add a page body
        out.println("<h1>" + "Registration Results" + "</h1>");

        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String password = request.getParameter("password1");
        String confirmation = request.getParameter("password2");
        if (!Objects.equals(password, confirmation)){
            out.println("<h4>oops, looks like something went wrong</h4>");
        }else{
            if (UserStorage.registerUser(new User(name, lastname, age, email, password))){
                out.println("<h4>Welcome "+name+" "+lastname+"</h4>");
            }else{
                out.println("<h4>oops, looks like something went wrong</h4>");
            }
        }
        out.println("<a href=\"index.html\">Domů</a>");

        // End of HTML page
        out.println("</body></html>");
        // Close stream object
        out.close();
    }
}
