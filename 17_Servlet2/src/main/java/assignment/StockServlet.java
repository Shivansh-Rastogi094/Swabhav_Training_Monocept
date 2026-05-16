package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/stock")
public class StockServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("productId");
		PrintWriter out = response.getWriter();

		if (id == null) {
			out.println("Invalid product");
			return;
		}

		if (id.equals("1023")) {
			out.println("Product: Laptop, Stock: 10, Available");
		} else if (id.equals("1024")) {
			out.println("Product: Phone, Stock: 0, Out of stock");
		} else {
			out.println("Product not found");
		}
	}
}