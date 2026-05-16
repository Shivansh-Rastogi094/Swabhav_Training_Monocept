package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rating")
public class RatingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String movie = request.getParameter("movieName");
        PrintWriter out = response.getWriter();

        if (movie == null) {
            out.println("Invalid movie");
            return;
        }

        if (movie.equalsIgnoreCase("Inception")) {
            out.println("Rating: 9, Genre: Sci-Fi, Reviews: Excellent");
        } else if (movie.equalsIgnoreCase("Avengers")) {
            out.println("Rating: 8.5, Genre: Action, Reviews: Great");
        } else {
            out.println("Movie not found");
        }
    }
}