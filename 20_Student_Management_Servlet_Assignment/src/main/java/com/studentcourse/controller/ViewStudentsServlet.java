package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

public class ViewStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
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
        List<Student> students;

        if (search != null && !search.trim().isEmpty()) {
            students = studentDAO.searchStudents(search.trim());
            request.setAttribute("searchTerm", search);
        } else {
            students = studentDAO.getAllStudents();
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(request, response);
    }
}
