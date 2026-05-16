package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.model.Course;

public class ViewCoursesServlet extends HttpServlet {
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

        String search = request.getParameter("search");
        List<Course> courses;

        if (search != null && !search.trim().isEmpty()) {
            courses = courseDAO.searchCourses(search.trim());
            request.setAttribute("searchTerm", search);
        } else {
            courses = courseDAO.getAllCourses();
        }

        request.setAttribute("courses", courses);
        request.getRequestDispatcher("/WEB-INF/views/course-list.jsp").forward(request, response);
    }
}
