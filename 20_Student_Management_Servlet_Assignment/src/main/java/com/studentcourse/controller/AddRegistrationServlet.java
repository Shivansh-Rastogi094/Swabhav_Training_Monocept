package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.dao.StudentDAO;
import com.studentcourse.dao.CourseDAO;

public class AddRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegistrationDAO registrationDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    @Override
    public void init() throws ServletException {
        registrationDAO = new RegistrationDAO();
        studentDAO = new StudentDAO();
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

        request.setAttribute("students", studentDAO.getAllStudents());
        request.setAttribute("courses", courseDAO.getAllCourses());
        request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));

        if (registrationDAO.isAlreadyRegistered(studentId, courseId)) {
            request.setAttribute("error", "Student is already registered for this course.");
            request.setAttribute("students", studentDAO.getAllStudents());
            request.setAttribute("courses", courseDAO.getAllCourses());
            request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(request, response);
            return;
        }

        if (registrationDAO.addRegistration(studentId, courseId)) {
            response.sendRedirect(request.getContextPath() + "/registrations");
        } else {
            request.setAttribute("error", "Database error occurred.");
            request.setAttribute("students", studentDAO.getAllStudents());
            request.setAttribute("courses", courseDAO.getAllCourses());
            request.getRequestDispatcher("/WEB-INF/views/registration-form.jsp").forward(request, response);
        }
    }
}
