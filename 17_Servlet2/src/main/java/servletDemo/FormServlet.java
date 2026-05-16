package servletDemo;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/submit")
public class FormServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String age = request.getParameter("age");
	    String dob = request.getParameter("dob");
	    String city = request.getParameter("city");
	    String gender = request.getParameter("gender");
	    String about = request.getParameter("about");

	   
	    String[] skills = request.getParameterValues("skills");

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<h2>Submitted Details</h2>");
	    out.println("Name: " + name + "<br>");
	    out.println("Email: " + email + "<br>");
	    out.println("Age: " + age + "<br>");
	    out.println("DOB: " + dob + "<br>");
	    out.println("City: " + city + "<br>");
	    out.println("Gender: " + gender + "<br>");

	    out.println("Skills: ");
	    if (skills != null) {
	        for (String skill : skills) {
	            out.println(skill + " ");
	        }
	    }

	    out.println("<br>About: " + about);
	}
}