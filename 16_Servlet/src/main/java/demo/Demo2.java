package demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home1")
public class Demo2 extends HttpServlet {

	@Override
	public void init() throws ServletException {

		System.out.println("Server Started");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Request 1 Handeled in console Successfully");
		PrintWriter out = resp.getWriter();
		out.println("Request 1 Handeled in browser Successfully");
		System.out.println("Request 2 Handeled in console Successfully");
		out.println("Request 2 Handeled in browser Successfully");
	}

	@Override
	public void destroy() {
		System.out.println("Server Closed");

	}

}
