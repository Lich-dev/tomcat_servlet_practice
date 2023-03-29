package MVC.dispatcher.disp;

import MVC.dispatcher.controller.Controller;
import MVC.dispatcher.controller.movie.MovieListController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DispatcherServlet",urlPatterns = "*.dispatch")
public class DispatcherServlet extends HttpServlet {

    private static final Map<String, Controller> urlMappings = new HashMap<>();

    @Override
    public void init() {
        urlMappings.put("/movie-list.dispatch", new MovieListController());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);

    }

    private static void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Controller controller = urlMappings.get(req.getServletPath());
        if (controller != null){
            String view = controller.handleRequest(req, resp);
            req.getRequestDispatcher(view).forward(req,resp);
            return;
        }
        req.setAttribute("url",req.getServletPath());
        req.getRequestDispatcher("/view/error.jsp").forward(req,resp);
    }
}
