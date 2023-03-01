package cv4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@WebServlet(name = "Registration Servlet",value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {
    //language=RegExp
    private static final String REG_EX_NAME = "^[A-ZÁ-Ž][a-zá-ž]{1,29}$";//regularni vyrazy, alt-enter inject, regexp
    private static final String REG_EX_AGE = "^[1-9]\\d{0,2}$";//10+
    public static final String REG_EX_EMAIL = "^[a-z][\\w\\-\\.]{1,30}@[a-z]{1,30}\\.[a-z]{1,3}$";
    public static final String REG_EX_PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[./,?(@){}])(?!.*[!]).{8,50}$";
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

        List<String> validationViolations = new ArrayList<>();

        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String password = request.getParameter("password1");
        String confirmation = request.getParameter("password2");

        //Pattern compile = Pattern.compile(REG_EX_NAME);
        //compile.matcher(name);

        if (name.trim().isEmpty()){
            validationViolations.add("first name empty!");
        }else if (!name.matches(REG_EX_NAME)){
            validationViolations.add("first name contains unallowed characters");
        }
        if (lastname.trim().isEmpty()){
            validationViolations.add("last name empty!");
        }else if (!name.matches(REG_EX_NAME)){
            validationViolations.add("last name contains unallowed characters");
        }
        if (!age.matches(REG_EX_AGE)||Integer.parseInt(age)<18){
            validationViolations.add("invalid age!");
        }
        if (!Objects.equals(password, confirmation)){
            validationViolations.add("passwords dont match!");
        }
        if (!password.matches(REG_EX_PASSWORD)){
            validationViolations.add("invalid password!");
        }
        if (!email.matches(REG_EX_EMAIL)){
            validationViolations.add("invalid email!");
        }
        if (validationViolations.isEmpty()){
            if (UserStorage.registerUser(new User(name, lastname, age, email, password))){
                out.println("<h4>Welcome "+name+" "+lastname+"</h4>");
            }else {
                out.println("<h4>user with that email already exists!</h4>");
            }
        }else{
            out.println("<ul>");
            for (String violation :
                    validationViolations) {
                out.println("<li>"+violation+"</li>");
            }
            out.println("</ul>");
        }

        out.println("<a href=\"index.html\">Domů</a>");

        // End of HTML page
        out.println("</body></html>");
        // Close stream object
        out.close();
    }
}
