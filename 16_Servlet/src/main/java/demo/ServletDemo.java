package demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class ServletDemo extends HttpServlet{

	@Override
	public void init() throws ServletException{
//		super.init();
		System.out.println("Servlet initalised");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println("Request 1 Handeled Successfully");
		PrintWriter out = resp.getWriter();
		out.println("Request 1 Handeled Successfully");
		System.out.println("Request 2 Handeled Successfully");
		out.println("Request 2 Handeled Successfully");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		PrintWriter out = resp.getWriter();
		out.println("Request 3 Handeled Successfully");
		System.out.println("Request 3 Handeled Successfully");
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
//		super.destroy();
		System.out.println("Servlet destroyed");

	}
	
}
