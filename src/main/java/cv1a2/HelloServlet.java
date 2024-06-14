package cv1a2;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private PrintWriter out;
    private String getCurrectDayTime(){
        Date date = new Date();
        SimpleDateFormat SDT = new SimpleDateFormat("HH:mm:ss dd.MM.yyyy");
        return SDT.format(date);
    }

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        //response.setIntHeader("Refresh",1);//better done with js of course
        //response.sendRedirect("/hullo.jsp");//immediate redirect



        // Hello
        out = response.getWriter();
        //out.println("<html><body>");
        //out.println("<h1>" + message + "</h1>");
        //out.println("</body></html>");

        out.println("<ul>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<li>"+headerName+":"+headerValue+"</li>");
        }
        out.println("</ul>");

        String hullo = "word";//replace with loaded file?

        out.println(hullo);

        out.println(getCurrectDayTime());

        //new Timer(100, e -> spam()).start();
    }
    private void spam(){
        System.out.println("a");
        out.println("spam");//doesnt send it to client
    }

    public void destroy() {
    }
}