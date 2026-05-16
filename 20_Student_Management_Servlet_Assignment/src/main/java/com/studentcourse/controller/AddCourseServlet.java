package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

public class AddCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDAO courseDAO;

    @Override
    public void init() throws ServletException {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("courseName");
        String duration = request.getParameter("duration");
        String feesStr = request.getParameter("fees");
        String trainer = request.getParameter("trainerName");

        if (name == null || duration == null || feesStr == null || trainer == null) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
            return;
        }

        double fees = Double.parseDouble(feesStr);
        if (fees <= 0) {
            request.setAttribute("error", "Fees must be greater than 0.");
            request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
            return;
        }

        Course course = new Course();
        course.setCourseName(name);
        course.setDuration(duration);
        course.setFees(fees);
        course.setTrainerName(trainer);

        if (courseDAO.addCourse(course)) {
            response.sendRedirect(request.getContextPath() + "/courses");
        } else {
            request.setAttribute("error", "Database error occurred.");
            request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
        }
    }
}
