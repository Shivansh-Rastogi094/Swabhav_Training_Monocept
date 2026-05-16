package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class CurrencyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String amountStr = request.getParameter("amount");
		String from = request.getParameter("from");
		String to = request.getParameter("to");

		PrintWriter out = response.getWriter();

		try {
			double amount = Double.parseDouble(amountStr);
			double rate = 1;

			if (from.equals("USD") && to.equals("INR"))
				rate = 83;
			else if (from.equals("INR") && to.equals("USD"))
				rate = 0.012;

			double result = amount * rate;
			out.println("Converted Amount: " + result);

		} catch (Exception e) {
			out.println("Invalid input");
		}
	}
}