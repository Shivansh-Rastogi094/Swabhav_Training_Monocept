package com.studentcourse.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.model.Student;

public class UpdateStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        int id = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("studentName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));
        String city = request.getParameter("city");

        if (age < 18) {
            Student s = new Student(id, name, email, phone, age, city);
            request.setAttribute("student", s);
            request.setAttribute("error", "Age must be 18 or above.");
            request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
            return;
        }

        if (phone == null || !phone.matches("\\d{10}")) {
            Student s = new Student(id, name, email, phone, age, city);
            request.setAttribute("student", s);
            request.setAttribute("error", "Phone number must be 10 digits.");
            request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
            return;
        }

        Student student = new Student(id, name, email, phone, age, city);
        if (studentDAO.updateStudent(student)) {
            response.sendRedirect(request.getContextPath() + "/students");
        } else {
            request.setAttribute("student", student);
            request.setAttribute("error", "Database error occurred.");
            request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
        }
    }
}
