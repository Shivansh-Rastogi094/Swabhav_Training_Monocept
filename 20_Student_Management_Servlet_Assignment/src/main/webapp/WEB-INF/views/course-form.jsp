<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Course | SMS ADMIN</title>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
    <style>
        body { display: block; padding: 2rem; max-width: 1200px; margin: 0 auto; }
        .top-nav { display: flex; justify-content: space-between; align-items: center; padding: 1rem 0; margin-bottom: 2rem; border-bottom: 1px solid var(--glass-border); }
        .nav-links a { margin-left: 1.5rem; text-decoration: none; color: var(--text-muted); font-size: 0.9rem; }
        .nav-links a:hover { color: var(--accent); }
        .form-card-wrapper { display: flex; justify-content: center; align-items: center; padding: 2rem 0; }
        .form-card { width: 100%; max-width: 500px; padding: 2.5rem; background: var(--glass-bg); border: 1px solid var(--glass-border); border-radius: 24px; }
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
            <h1 style="text-align: left; margin-bottom: 0.5rem;">New Course</h1>
            <p class="subtitle" style="text-align: left; margin-bottom: 2rem;">Setup a new educational program.</p>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error-msg"><%= request.getAttribute("error") %></div>
            <% } %>

            <form action="${pageContext.request.contextPath}/course/add" method="post">
                <div class="form-group">
                    <label for="courseName">Course Name</label>
                    <input type="text" id="courseName" name="courseName" required placeholder="e.g. Java Full Stack">
                </div>
                <div class="form-group">
                    <label for="duration">Duration</label>
                    <input type="text" id="duration" name="duration" required placeholder="e.g. 3 Months">
                </div>
                <div class="form-group">
                    <label for="fees">Fees ($)</label>
                    <input type="number" step="0.01" id="fees" name="fees" required placeholder="e.g. 499.00">
                </div>
                <div class="form-group">
                    <label for="trainerName">Trainer Name</label>
                    <input type="text" id="trainerName" name="trainerName" required placeholder="Enter trainer's name">
                </div>
                <button type="submit" style="margin-top: 1rem;">Create Course</button>
            </form>
            <a href="${pageContext.request.contextPath}/courses" class="back-link">← Back to Course List</a>
        </div>
    </div>
</body>
</html>
