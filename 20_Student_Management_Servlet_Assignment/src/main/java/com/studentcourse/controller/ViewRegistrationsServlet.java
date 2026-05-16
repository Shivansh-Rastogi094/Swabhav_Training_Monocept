package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.model.Registration;

public class ViewRegistrationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistrationDAO registrationDAO;

    @Override
    public void init() throws ServletException {
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

        List<Registration> registrations = registrationDAO.getAllRegistrations();
        request.setAttribute("registrations", registrations);
        request.getRequestDispatcher("/WEB-INF/views/registration-list.jsp").forward(request, response);
    }
}
