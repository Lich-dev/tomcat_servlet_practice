package MVC.dispatcher.controller.movie;

import MVC.dispatcher.controller.Controller;
import MVC.dispatcher.model.Movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class MovieListController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Madagascar"));
        req.setAttribute("movies",movies);
        return "/view/movie-list.jsp";
    }
}
