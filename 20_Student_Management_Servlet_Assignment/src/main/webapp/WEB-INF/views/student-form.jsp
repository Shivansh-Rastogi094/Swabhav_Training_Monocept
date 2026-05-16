<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Student | SMS ADMIN</title>
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

    <div class="form-card-wrapper">
        <div class="form-card">
            <h1 style="text-align: left; margin-bottom: 0.5rem;">New Student</h1>
            <p class="subtitle" style="text-align: left; margin-bottom: 2rem;">Register a new student in the system.</p>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error-msg"><%= request.getAttribute("error") %></div>
            <% } %>

            <form action="${pageContext.request.contextPath}/student/add" method="post">
                <div class="form-grid">
                    <div class="form-group full-width">
                        <label for="studentName">Full Name</label>
                        <input type="text" id="studentName" name="studentName" required placeholder="Enter student name">
                    </div>
                    <div class="form-group full-width">
                        <label for="email">Email Address</label>
                        <input type="email" id="email" name="email" required placeholder="student@example.com">
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Number</label>
                        <input type="text" id="phone" name="phone" required placeholder="10 digits">
                    </div>
                    <div class="form-group">
                        <label for="age">Age</label>
                        <input type="number" id="age" name="age" required min="18">
                    </div>
                    <div class="form-group full-width">
                        <label for="city">City</label>
                        <input type="text" id="city" name="city" required placeholder="Enter city">
                    </div>
                </div>
                <button type="submit" style="margin-top: 1rem;">Register Student</button>
            </form>
            <a href="${pageContext.request.contextPath}/students" class="back-link">← Back to Student List</a>
        </div>
    </div>
</body>
</html>
