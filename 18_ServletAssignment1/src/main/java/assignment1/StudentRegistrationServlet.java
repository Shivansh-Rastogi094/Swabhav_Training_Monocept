package assignment1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class StudentRegistrationServlet extends HttpServlet {

    public void init() {
        System.out.println("Servlet Initialized");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String ageStr = request.getParameter("age");
        String course = request.getParameter("course");
        String batch = request.getParameter("batch");

        boolean isValid = true;
        int age = 0;

        if (name == null || name.isEmpty()) isValid = false;
        if (email == null || email.isEmpty()) isValid = false;

        try {
            age = Integer.parseInt(ageStr);
            if (age < 18) isValid = false;
        } catch (Exception e) {
            isValid = false;
        }

        if (course == null || course.isEmpty()) isValid = false;
        if (batch == null || batch.isEmpty()) isValid = false;

        if (isValid) {
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("age", age);
            request.setAttribute("course", course);
            request.setAttribute("batch", batch);

            RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
            rd.forward(request, response);

        } else {
            response.sendRedirect("register.jsp");
        }
    }

    public void destroy() {
        System.out.println("Servlet Destroyed");
    }
}
