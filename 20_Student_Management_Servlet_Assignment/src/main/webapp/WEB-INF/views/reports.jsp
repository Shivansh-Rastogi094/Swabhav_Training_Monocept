<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.studentcourse.model.Registration" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Enrollment Reports | SMS ADMIN</title>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
    <style>
        body { display: block; padding: 2rem; max-width: 1200px; margin: 0 auto; }
        .top-nav { display: flex; justify-content: space-between; align-items: center; padding: 1rem 0; margin-bottom: 2rem; border-bottom: 1px solid var(--glass-border); }
        .nav-links a { margin-left: 1.5rem; text-decoration: none; color: var(--text-muted); font-size: 0.9rem; }
        .nav-links a:hover { color: var(--accent); }
        .nav-links a.active { color: var(--accent); font-weight: 600; }
        .report-section { margin-bottom: 3rem; }
        .course-header { 
            background: rgba(255, 255, 255, 0.05); 
            padding: 1rem 1.5rem; 
            border-radius: 12px; 
            margin-bottom: 1rem; 
            display: flex; 
            justify-content: space-between;
            align-items: center;
            border-left: 4px solid var(--accent);
        }
        .course-header h3 { margin: 0; color: var(--accent); }
        .student-grid { 
            display: grid; 
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); 
            gap: 1rem; 
            padding-left: 1rem;
        }
        .student-card { 
            background: var(--glass-bg); 
            border: 1px solid var(--glass-border); 
            padding: 1rem; 
            border-radius: 12px; 
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .reg-date { font-size: 0.75rem; color: var(--text-muted); }
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
            <a href="${pageContext.request.contextPath}/reports" class="active">Reports</a>
            <a href="${pageContext.request.contextPath}/logout" style="color: var(--error); margin-left: 2rem;">Logout</a>
        </div>
    </nav>

    <h1 style="margin-bottom: 2rem;">Course-wise Enrollment Report</h1>

    <% 
        List<Registration> reports = (List<Registration>) request.getAttribute("reports");
        if (reports != null && !reports.isEmpty()) {
            String currentCourse = "";
            boolean first = true;
            int count = 0;
            
            for (Registration r : reports) {
                if (!r.getCourseName().equals(currentCourse)) {
                    if (!first) {
                        out.print("</div></div>"); // Close previous grid and section
                    }
                    currentCourse = r.getCourseName();
                    count = 0;
    %>
                <div class="report-section">
                    <div class="course-header">
                        <h3><%= currentCourse %></h3>
                    </div>
                    <div class="student-grid">
    <%
                    first = false;
                }
    %>
                <div class="student-card">
                    <div>
                        <div style="font-weight: 600;"><%= r.getStudentName() %></div>
                        <div class="reg-date">Joined: <%= r.getRegistrationDate().substring(0, 10) %></div>
                    </div>
                    <span style="font-size: 0.7rem; color: var(--accent); border: 1px solid var(--accent); padding: 2px 6px; border-radius: 4px;"><%= r.getStatus() %></span>
                </div>
    <%
            }
            out.print("</div></div>"); // Close the final tags
        } else {
    %>
        <p style="text-align: center; padding: 5rem; color: var(--text-muted);">No enrollment data available to generate reports.</p>
    <% } %>

</body>
</html>
