<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard | SMS ADMIN</title>
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
    <style>
        body { display: block; padding: 2rem; max-width: 1200px; margin: 0 auto; }
        .top-nav { display: flex; justify-content: space-between; align-items: center; padding: 1rem 0; margin-bottom: 2rem; border-bottom: 1px solid var(--glass-border); }
        .nav-links a { margin-left: 1.5rem; text-decoration: none; color: var(--text-muted); font-size: 0.9rem; }
        .nav-links a:hover { color: var(--accent); }
        .nav-links a.active { color: var(--accent); font-weight: 600; }
        .header { margin-bottom: 3rem; padding: 2.5rem; background: var(--glass-bg); border: 1px solid var(--glass-border); border-radius: 24px; text-align: center; }
        .stats-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(220px, 1fr)); gap: 1.5rem; margin-bottom: 3rem; }
        .stat-card { padding: 2rem; background: var(--glass-bg); border: 1px solid var(--glass-border); border-radius: 24px; text-align: center; transition: all 0.3s ease; cursor: pointer; }
        .stat-card:hover { transform: translateY(-10px); border-color: var(--accent); background: rgba(56, 189, 248, 0.05); }
        .stat-card h3 { color: var(--text-muted); font-size: 0.8rem; text-transform: uppercase; letter-spacing: 1px; margin-bottom: 1rem; }
        .stat-card .value { font-size: 3rem; font-weight: 700; background: var(--primary-gradient); -webkit-background-clip: text; -webkit-text-fill-color: transparent; }
    </style>
</head>
<body>
    <nav class="top-nav">
        <div class="nav-brand" style="font-weight: 700; font-size: 1.2rem; background: var(--primary-gradient); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">SMS ADMIN</div>
        <div class="nav-links">
            <a href="${pageContext.request.contextPath}/dashboard" class="active">Dashboard</a>
            <a href="${pageContext.request.contextPath}/students">Students</a>
            <a href="${pageContext.request.contextPath}/courses">Courses</a>
            <a href="${pageContext.request.contextPath}/registrations">Enrollments</a>
            <a href="${pageContext.request.contextPath}/reports">Reports</a>
            <a href="${pageContext.request.contextPath}/logout" style="color: var(--error); margin-left: 2rem;">Logout</a>
        </div>
    </nav>

    <div class="header">
        <h1 style="font-size: 2.5rem; margin-bottom: 0.5rem;">Hello, ${loggedInUser}!</h1>
        <p style="color: var(--text-muted);">Manage your institution's students and courses with ease.</p>
    </div>

    <div class="stats-grid">
        <div class="stat-card" onclick="location.href='${pageContext.request.contextPath}/students'">
            <h3>Students</h3>
            <div class="value">${studentCount}</div>
        </div>
        <div class="stat-card" onclick="location.href='${pageContext.request.contextPath}/courses'">
            <h3>Courses</h3>
            <div class="value">${courseCount}</div>
        </div>
        <div class="stat-card" onclick="location.href='${pageContext.request.contextPath}/registrations'">
            <h3>Enrollments</h3>
            <div class="value">${registrationCount}</div>
        </div>
        <div class="stat-card" onclick="location.href='${pageContext.request.contextPath}/reports'" style="border: 1px solid var(--accent);">
            <h3>Reports</h3>
            <div class="value">View</div>
        </div>
    </div>

</body>
</html>
