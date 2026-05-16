package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

public class UpdateCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDAO courseDAO;

    @Override
    public void init() throws ServletException {
        courseDAO = new CourseDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int id = Integer.parseInt(request.getParameter("courseId"));
        String name = request.getParameter("courseName");
        String duration = request.getParameter("duration");
        double fees = Double.parseDouble(request.getParameter("fees"));
        String trainer = request.getParameter("trainerName");

        if (fees <= 0) {
            Course course = new Course(id, name, duration, fees, trainer);
            request.setAttribute("course", course);
            request.setAttribute("error", "Fees must be greater than 0.");
            request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);
            return;
        }

        Course course = new Course(id, name, duration, fees, trainer);
        if (courseDAO.updateCourse(course)) {
            response.sendRedirect(request.getContextPath() + "/courses");
        } else {
            request.setAttribute("course", course);
            request.setAttribute("error", "Database error occurred.");
            request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);
        }
    }
}
