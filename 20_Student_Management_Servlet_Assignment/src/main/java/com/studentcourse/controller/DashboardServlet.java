package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.RegistrationDAO;

public class DashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private RegistrationDAO registrationDAO;

    @Override
    public void init() throws ServletException {
        System.out.println("[LIFECYCLE] DashboardServlet: init() called. DAOs initialized.");
        studentDAO = new StudentDAO();
        courseDAO = new CourseDAO();
        registrationDAO = new RegistrationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] DashboardServlet: doGet() called. Fetching dashboard counts.");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        request.setAttribute("studentCount", studentDAO.getStudentCount());
        request.setAttribute("courseCount", courseDAO.getCourseCount());
        request.setAttribute("registrationCount", registrationDAO.getRegistrationCount());

        request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] DashboardServlet: doPost() called.");
        doGet(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("[LIFECYCLE] DashboardServlet: destroy() called.");
    }
}
