package cv3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "ParameterServlet", value = "/parameter-servlet")
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Set refresh, autoload time as n seconds
        // (It refreshes the browser every second)
        //response.setIntHeader("Refresh", 1);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head><meta charset=\"UTF-8\"><title>");
        // Browser bookmark title
        out.println("HTTP parametry");
        out.println("</title></head><body>");

        // Add a page body
        out.println("<h1>" + "HTTP parametry (GET)" + "</h1>");

        out.println("<ul>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            out.println("<li>"+parameterName+": "+parameterValue+"</li>");
        }
        out.println("</ul>");

        out.println("<a href=\"index.html\">Domů</a>");

        // End of HTML page
        out.println("</body></html>");
        // Close stream object
        out.close();
    }

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
        out.println("HTTP parametry");
        out.println("</title></head><body>");

        // Add a page body
        out.println("<h1>" + "HTTP parametry (POST)" + "</h1>");

        out.println("<ul>");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String parameterName = parameterNames.nextElement();
            String parameterValue = request.getParameter(parameterName);
            out.println("<li>"+parameterName+": "+parameterValue+"</li>");
        }
        out.println("</ul>");

        out.println("<a href=\"index.html\">Domů</a>");

        // End of HTML page
        out.println("</body></html>");
        // Close stream object
        out.close();
    }
}
