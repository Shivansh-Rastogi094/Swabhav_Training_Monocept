<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Students | Student Management</title>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
    <style>
        body { display: block; padding: 2rem; max-width: 1200px; margin: 0 auto; }
        .top-nav { display: flex; justify-content: space-between; align-items: center; padding: 1rem 0; margin-bottom: 2rem; border-bottom: 1px solid var(--glass-border); }
        .nav-links a { margin-left: 1.5rem; text-decoration: none; color: var(--text-muted); font-size: 0.9rem; }
        .nav-links a:hover { color: var(--accent); }
        .nav-links a.active { color: var(--accent); font-weight: 600; }
        .page-header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 2rem; }
        .table-container { background: var(--glass-bg); border: 1px solid var(--glass-border); border-radius: 20px; overflow: hidden; }
        table { width: 100%; border-collapse: collapse; text-align: left; }
        th { background: rgba(255, 255, 255, 0.05); padding: 1.25rem 1rem; font-size: 0.85rem; color: var(--text-muted); text-transform: uppercase; }
        td { padding: 1.25rem 1rem; border-bottom: 1px solid var(--glass-border); }
        .btn-add { padding: 0.75rem 1.5rem; text-decoration: none; background: var(--primary-gradient); color: white; border-radius: 12px; font-weight: 600; }
        .action-btn { padding: 0.5rem 1rem; border-radius: 8px; text-decoration: none; font-size: 0.85rem; font-weight: 600; margin-right: 0.5rem; }
        .btn-edit { color: var(--accent); border: 1px solid var(--accent); }
        .btn-delete { color: var(--error); border: 1px solid var(--error); }
        .search-container { margin-bottom: 1.5rem; display: flex; gap: 0.5rem; }
        .search-container input { flex: 1; padding: 0.75rem 1rem; background: rgba(255, 255, 255, 0.05); border: 1px solid var(--glass-border); border-radius: 12px; color: white; }
        .btn-search { padding: 0.75rem 1.5rem; background: rgba(255, 255, 255, 0.1); color: white; border: 1px solid var(--glass-border); border-radius: 12px; cursor: pointer; }
    </style>
</head>
<body>
    <nav class="top-nav">
        <div class="nav-brand" style="font-weight: 700; font-size: 1.2rem; background: var(--primary-gradient); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">SMS ADMIN</div>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
            <a href="${pageContext.request.contextPath}/students" class="active">Students</a>
            <a href="${pageContext.request.contextPath}/courses">Courses</a>
            <a href="${pageContext.request.contextPath}/registrations">Enrollments</a>
            <a href="${pageContext.request.contextPath}/reports">Reports</a>
            <a href="${pageContext.request.contextPath}/logout" style="color: var(--error); margin-left: 2rem;">Logout</a>
        </div>
    </nav>

    <div class="page-header">
        <h1>Student Directory</h1>
        <a href="${pageContext.request.contextPath}/student/add" class="btn-add">Add New Student</a>
    </div>

    <% if (request.getAttribute("errorMsg") != null) { %>
        <div class="error-msg" style="margin-bottom: 1.5rem;"><%= request.getAttribute("errorMsg") %></div>
    <% } %>

    <form action="${pageContext.request.contextPath}/students" method="get" class="search-container">
        <input type="text" name="search" placeholder="Search students by name, email, or city..." value="<%= request.getAttribute("searchTerm") != null ? request.getAttribute("searchTerm") : "" %>">
        <button type="submit" class="btn-search">Search</button>
        <% if (request.getAttribute("searchTerm") != null) { %>
            <a href="${pageContext.request.contextPath}/students" class="btn-search" style="text-decoration: none; text-align: center;">Clear</a>
        <% } %>
    </form>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Age</th>
                    <th>City</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Student> students = (List<Student>) request.getAttribute("students");
                    if (students != null && !students.isEmpty()) {
                        for (Student s : students) {
                %>
                    <tr>
                        <td>#<%= s.getStudentId() %></td>
                        <td style="font-weight: 600;"><%= s.getStudentName() %></td>
                        <td><%= s.getEmail() %></td>
                        <td><%= s.getPhone() %></td>
                        <td><%= s.getAge() %></td>
                        <td><%= s.getCity() %></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/student/edit?id=<%= s.getStudentId() %>" class="action-btn btn-edit">Edit</a>
                            <a href="${pageContext.request.contextPath}/student/delete?id=<%= s.getStudentId() %>" class="action-btn btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                <% 
                        }
                    } else {
                %>
                    <tr><td colspan="7" style="text-align: center; padding: 3rem; color: var(--text-muted);">No students found.</td></tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
