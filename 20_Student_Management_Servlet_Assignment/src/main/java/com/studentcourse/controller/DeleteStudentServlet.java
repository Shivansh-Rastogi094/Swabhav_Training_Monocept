package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.dao.RegistrationDAO;

public class DeleteStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;
    private RegistrationDAO registrationDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
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

            if (registrationDAO.hasRegistrations(id)) {
                request.setAttribute("errorMsg", "Cannot delete student: They are currently registered for courses.");
                request.getRequestDispatcher("/students").forward(request, response);
            } else {
                if (studentDAO.deleteStudent(id)) {
                    response.sendRedirect(request.getContextPath() + "/students");
                } else {
                    request.setAttribute("errorMsg", "Deletion failed. Database error.");
                    request.getRequestDispatcher("/students").forward(request, response);
                }
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/students");
        }
    }
}
