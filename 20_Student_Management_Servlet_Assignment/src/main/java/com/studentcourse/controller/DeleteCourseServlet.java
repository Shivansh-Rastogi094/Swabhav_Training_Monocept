package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.dao.RegistrationDAO;

public class DeleteCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDAO courseDAO;
    private RegistrationDAO registrationDAO;

    @Override
    public void init() throws ServletException {
        courseDAO = new CourseDAO();
        registrationDAO = new RegistrationDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);

            if (registrationDAO.hasCourseRegistrations(id)) {
                request.setAttribute("errorMsg", "Cannot delete course: Students are currently registered.");
                request.getRequestDispatcher("/courses").forward(request, response);
            } else {
                if (courseDAO.deleteCourse(id)) {
                    response.sendRedirect(request.getContextPath() + "/courses");
                } else {
                    request.setAttribute("errorMsg", "Deletion failed. Database error.");
                    request.getRequestDispatcher("/courses").forward(request, response);
                }
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/courses");
        }
    }
}
