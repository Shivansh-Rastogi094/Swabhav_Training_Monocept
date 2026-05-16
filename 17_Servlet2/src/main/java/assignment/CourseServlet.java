package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String dept = request.getParameter("department");
		PrintWriter out = response.getWriter();

		if (dept == null) {
			out.println("Invalid department");
			return;
		}

		if (dept.equalsIgnoreCase("CS")) {
			out.println("DSA, OS, DBMS");
		} else if (dept.equalsIgnoreCase("ME")) {
			out.println("Thermodynamics, Mechanics");
		} else if (dept.equalsIgnoreCase("EE")) {
			out.println("Circuits, Signals");
		} else {
			out.println("Department not found");
		}
	}
}