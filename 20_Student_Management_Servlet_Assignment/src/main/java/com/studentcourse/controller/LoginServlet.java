package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.AdminDAO;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;

    @Override
    public void init() throws ServletException {
        System.out.println("[LIFECYCLE] LoginServlet: init() called. AdminDAO initialized.");
        adminDAO = new AdminDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] LoginServlet: doGet() called.");
        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] LoginServlet: doPost() called. Processing credentials.");

        String username = request.getParameter("username");
        String pass = request.getParameter("password");

        if (adminDAO.validateAdmin(username, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedInUser", username);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            request.setAttribute("error", "Invalid username or password.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("[LIFECYCLE] LoginServlet: destroy() called.");
    }
}
