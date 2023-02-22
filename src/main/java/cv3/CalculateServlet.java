package cv3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "calculatorServlet", value = "/calculator-servlet")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head><meta charset=\"UTF-8\"><title>");
        // Browser bookmark title
        out.println("Calculation result");
        out.println("</title></head><body>");

        // Add a page body
        out.println("<h1>" + "HTTP (POST) Result" + "</h1>");

        out.println("<ul>");
        Enumeration<String> parameterNames = request.getParameterNames();

        int fNumber = Integer.parseInt(request.getParameter("fnumber"));
        int sNumber = Integer.parseInt(request.getParameter("snumber"));
        String operation = request.getParameter("operation");

        out.println("<h4> Solution: "+Calculate(fNumber,sNumber,operation)+"</h4>");

        out.println("</ul>");

        out.println("<a href=\"index.html\">Domů</a>");

        // End of HTML page
        out.println("</body></html>");
        // Close stream object
        out.close();
    }
    private static float Calculate(int fnumber, int snumber, String operation){
        switch (operation){
            case"plus":
                return (fnumber+snumber);
            case"minus":
                return (fnumber-snumber);
            case"multiply":
                return (fnumber*snumber);
            case"divide":
                return ((float)fnumber/snumber);
            default:
                return 0;
        }
    }
}
