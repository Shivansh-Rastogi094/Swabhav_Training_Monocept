package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentRegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String course = request.getParameter("course");

		PrintWriter out = response.getWriter();

		if (name.isEmpty() || email.isEmpty() || age < 18 || course == null) {
			out.println("Validation failed");
		} else {
			out.println("Registered: " + name + ", " + email + ", " + course);
		}
	}
}