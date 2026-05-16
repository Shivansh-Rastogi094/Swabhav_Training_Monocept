<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Registration" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Registrations | Student Management</title>
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
        th { background: rgba(255, 255, 255, 0.05); padding: 1.25rem 1rem; color: var(--text-muted); font-size: 0.85rem; text-transform: uppercase; }
        td { padding: 1.25rem 1rem; border-bottom: 1px solid var(--glass-border); }
        .badge { padding: 0.25rem 0.75rem; border-radius: 20px; font-size: 0.75rem; font-weight: 700; background: rgba(34, 197, 94, 0.1); color: #22c55e; }
        .btn-enroll { padding: 0.75rem 1.5rem; background: var(--primary-gradient); color: white; border-radius: 12px; text-decoration: none; font-weight: 600; }
        .btn-delete { color: var(--error); border: 1px solid var(--error); padding: 0.5rem 1rem; border-radius: 8px; text-decoration: none; font-size: 0.85rem; font-weight: 600; }
    </style>
</head>
<body>
    <nav class="top-nav">
        <div class="nav-brand" style="font-weight: 700; font-size: 1.2rem; background: var(--primary-gradient); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">SMS ADMIN</div>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
            <a href="${pageContext.request.contextPath}/students">Students</a>
            <a href="${pageContext.request.contextPath}/courses">Courses</a>
            <a href="${pageContext.request.contextPath}/registrations" class="active">Enrollments</a>
            <a href="${pageContext.request.contextPath}/reports">Reports</a>
            <a href="${pageContext.request.contextPath}/logout" style="color: var(--error); margin-left: 2rem;">Logout</a>
        </div>
    </nav>

    <div class="page-header">
        <h1>Course Enrollments</h1>
        <a href="${pageContext.request.contextPath}/registration/add" class="btn-enroll">New Registration</a>
    </div>

    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Reg ID</th>
                    <th>Student Name</th>
                    <th>Course Name</th>
                    <th>Enrollment Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Registration> regs = (List<Registration>) request.getAttribute("registrations");
                    if (regs != null && !regs.isEmpty()) {
                        for (Registration r : regs) {
                %>
                    <tr>
                        <td>#<%= r.getRegistrationId() %></td>
                        <td style="font-weight: 600;"><%= r.getStudentName() %></td>
                        <td style="font-weight: 600;"><%= r.getCourseName() %></td>
                        <td><%= r.getRegistrationDate() %></td>
                        <td><span class="badge"><%= r.getStatus() %></span></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/registration/delete?id=<%= r.getRegistrationId() %>" class="btn-delete" onclick="return confirm('Cancel this registration?')">Cancel</a>
                        </td>
                    </tr>
                <% 
                        }
                    } else {
                %>
                    <tr><td colspan="6" style="text-align: center; padding: 3rem; color: var(--text-muted);">No registrations found.</td></tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
