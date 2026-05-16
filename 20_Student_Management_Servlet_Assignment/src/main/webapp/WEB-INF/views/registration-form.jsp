<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Student, com.studentcourse.model.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Enrollment | SMS ADMIN</title>
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
            <h1 style="text-align: left; margin-bottom: 0.5rem;">New Enrollment</h1>
            <p class="subtitle" style="text-align: left; margin-bottom: 2rem;">Assign a student to a course.</p>

            <% if (request.getAttribute("error") != null) { %>
                <div class="error-msg"><%= request.getAttribute("error") %></div>
            <% } %>

            <form action="${pageContext.request.contextPath}/registration/add" method="post">
                <div class="form-group">
                    <label for="studentId">Select Student</label>
                    <select id="studentId" name="studentId" required>
                        <option value="">-- Choose a Student --</option>
                        <% 
                            List<Student> students = (List<Student>) request.getAttribute("students");
                            if (students != null) {
                                for (Student s : students) {
                        %>
                            <option value="<%= s.getStudentId() %>"><%= s.getStudentName() %> (ID: <%= s.getStudentId() %>)</option>
                        <% 
                                }
                            }
                        %>
                    </select>
                </div>

                <div class="form-group">
                    <label for="courseId">Select Course</label>
                    <select id="courseId" name="courseId" required>
                        <option value="">-- Choose a Course --</option>
                        <% 
                            List<Course> courses = (List<Course>) request.getAttribute("courses");
                            if (courses != null) {
                                for (Course c : courses) {
                        %>
                            <option value="<%= c.getCourseId() %>"><%= c.getCourseName() %> ($<%= c.getFees() %>)</option>
                        <% 
                                }
                            }
                        %>
                    </select>
                </div>

                <button type="submit" style="margin-top: 1rem;">Confirm Enrollment</button>
            </form>
            <a href="${pageContext.request.contextPath}/registrations" class="back-link">← Back to Enrollments</a>
        </div>
    </div>
</body>
</html>
