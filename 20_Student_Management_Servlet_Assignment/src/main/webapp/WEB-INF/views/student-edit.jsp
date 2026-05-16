<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.studentcourse.model.Student" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Student | SMS ADMIN</title>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
    <style>
        body { display: block; padding: 2rem; max-width: 1200px; margin: 0 auto; }
        .top-nav { display: flex; justify-content: space-between; align-items: center; padding: 1rem 0; margin-bottom: 2rem; border-bottom: 1px solid var(--glass-border); }
        .nav-links a { margin-left: 1.5rem; text-decoration: none; color: var(--text-muted); font-size: 0.9rem; }
        .nav-links a:hover { color: var(--accent); }
        .form-card-wrapper { display: flex; justify-content: center; align-items: center; padding: 2rem 0; }
        .form-card { width: 100%; max-width: 500px; padding: 2.5rem; background: var(--glass-bg); border: 1px solid var(--glass-border); border-radius: 24px; }
        .form-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 1.5rem; }
        .full-width { grid-column: span 2; }
        .back-link { display: block; margin-top: 1.5rem; text-align: center; font-size: 0.85rem; color: var(--text-muted); text-decoration: none; }
        .back-link:hover { color: var(--accent); }
    </style>
</head>
<body>
    <nav class="top-nav">
        <div class="nav-brand" style="font-weight: 700; font-size: 1.2rem; background: var(--primary-gradient); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">SMS ADMIN</div>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
            <a href="${pageContext.request.contextPath}/students">Students</a>
            <a href="${pageContext.request.contextPath}/courses">Courses</a>
            <a href="${pageContext.request.contextPath}/registrations">Enrollments</a>
            <a href="${pageContext.request.contextPath}/reports">Reports</a>
            <a href="${pageContext.request.contextPath}/logout" style="color: var(--error); margin-left: 2rem;">Logout</a>
        </div>
    </nav>

    <% Student s = (Student) request.getAttribute("student"); %>
    <div class="form-card-wrapper">
        <div class="form-card">
            <h1 style="text-align: left; margin-bottom: 0.5rem;">Edit Student</h1>
            <p class="subtitle" style="text-align: left; margin-bottom: 2rem;">Updating profile for #<%= s.getStudentId() %></p>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error-msg"><%= request.getAttribute("error") %></div>
            <% } %>

            <form action="${pageContext.request.contextPath}/student/update" method="post">
                <input type="hidden" name="studentId" value="<%= s.getStudentId() %>">
                <div class="form-grid">
                    <div class="form-group full-width">
                        <label for="studentName">Full Name</label>
                        <input type="text" id="studentName" name="studentName" value="<%= s.getStudentName() %>" required>
                    </div>
                    <div class="form-group full-width">
                        <label for="email">Email Address</label>
                        <input type="email" id="email" name="email" value="<%= s.getEmail() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Number</label>
                        <input type="text" id="phone" name="phone" value="<%= s.getPhone() %>" required>
                    </div>
                    <div class="form-group">
                        <label for="age">Age</label>
                        <input type="number" id="age" name="age" value="<%= s.getAge() %>" required min="18">
                    </div>
                    <div class="form-group full-width">
                        <label for="city">City</label>
                        <input type="text" id="city" name="city" value="<%= s.getCity() %>" required>
                    </div>
                </div>
                <button type="submit" style="margin-top: 1rem;">Update Profile</button>
            </form>
            <a href="${pageContext.request.contextPath}/students" class="back-link">← Cancel and Go Back</a>
        </div>
    </div>
</body>
</html>
