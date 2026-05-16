package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String productId = request.getParameter("productId");
		int rating = Integer.parseInt(request.getParameter("rating"));
		String review = request.getParameter("review");

		PrintWriter out = response.getWriter();

		if (rating < 1 || rating > 5 || review.isEmpty()) {
			out.println("Invalid feedback");
		} else {
			out.println("Thanks! Product: " + productId + ", Rating: " + rating);
		}
	}
}