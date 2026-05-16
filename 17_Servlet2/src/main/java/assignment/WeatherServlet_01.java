package assignment;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherServlet_01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String city = request.getParameter("city");
		PrintWriter out = response.getWriter();

		if (city == null || city.isEmpty()) {
			out.println("Invalid city");
			return;
		}

		String result;
		if (city.equalsIgnoreCase("Delhi")) {
			result = "Temp: 35°C, Humidity: 60%, Forecast: Sunny";
		} else if (city.equalsIgnoreCase("Mumbai")) {
			result = "Temp: 30°C, Humidity: 80%, Forecast: Humid";
		} else {
			result = "City not found";
		}

		out.println(result);
	}
}
