package com.project.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.project.app.model.Student;

public class StudentDAO {

    // Insert a new student
    public void addStudent(Connection conn, Student s) throws SQLException {
        String sql = "INSERT INTO student (id, name, age, branch) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setString(4, s.getBranch());
            ps.executeUpdate();
        }
    }

    //  Fetch a single student by ID 
    public Student getStudentById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("branch")
                    );
                }
            }
        }
        return null; // student not found
    }

    // Update name and branch 
    public void updateStudent(Connection conn, int id, String name, String branch) throws SQLException {
        String sql = "UPDATE student SET name = ?, branch = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, branch);
            ps.setInt(3, id);
            ps.executeUpdate();
        }
    }

    // Delete a student row
    public void deleteStudent(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // LEFT JOIN: all students including those with no registrations 
    public List<String[]> getAllStudentsWithRegistrations(Connection conn) throws SQLException {
        List<String[]> results = new ArrayList<>();
        String sql = "SELECT s.id, s.name, s.age, s.branch, r.course_name, r.fees_paid FROM student s LEFT JOIN registration r ON s.id = r.student_id ORDER BY s.id";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String course = rs.getString("course_name");
                String fees   = rs.getString("fees_paid");
                results.add(new String[]{
                    String.valueOf(rs.getInt("id")),
                    rs.getString("name"),
                    String.valueOf(rs.getInt("age")),
                    rs.getString("branch"),
                    (course != null) ? course : "-- No Course --",
                    (fees   != null) ? String.format("%.2f", rs.getDouble("fees_paid")) : "N/A"
                });
            }
        }
        return results;
    }
}
