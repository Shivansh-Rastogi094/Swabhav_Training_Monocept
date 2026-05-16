<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login | Student Course Management</title>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Outfit:wght@300;400;600;700&display=swap" rel="stylesheet">
    <!-- Main CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css">
</head>
<body>
    <div class="login-container">
        <header>
            <h1>Admin Portal</h1>
            <p class="subtitle">Student Course Registration System</p>
        </header>

        <%-- Error Message Handling --%>
        <% 
            String error = (String) request.getAttribute("errorMessage");
            if (error != null) { 
        %>
            <div class="error-msg">
                <%= error %>
            </div>
        <% } %>

        <form action="${pageContext.request.contextPath}/login-action" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" 
                       value="${rememberedUser != null ? rememberedUser : ''}" 
                       required autocomplete="username" placeholder="Enter admin username">
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" 
                       required autocomplete="current-password" placeholder="••••••••">
            </div>

            <div class="form-options">
                <label class="remember-me">
                    <input type="checkbox" name="remember" ${not empty rememberedUser ? 'checked' : ''}>
                    Remember me
                </label>
            </div>

            <button type="submit">Sign In to Dashboard</button>
        </form>

        <footer style="margin-top: 2rem; text-align: center; font-size: 0.75rem; color: var(--text-muted);">
            &copy; 2026 Student Management System. Secure Admin Access.
        </footer>
    </div>
</body>
</html>
