package com.project.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.project.app.model.Registration;

public class RegistrationDAO {

    // Check for duplicate registration 
    public boolean isDuplicateRegistration(Connection conn, int studentId, String courseName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM registration WHERE student_id = ? AND course_name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setString(2, courseName);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        }
    }

    // Insert a new registration 
    public void addRegistration(Connection conn, Registration r) throws SQLException {
        String sql = "INSERT INTO registration (student_id, course_name, fees_paid) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, r.getStudentId());
            ps.setString(2, r.getCourseName());
            ps.setDouble(3, r.getFeesPaid());
            ps.executeUpdate();
        }
    }

    // All registrations for a given student
    public List<Registration> getRegistrationsByStudentId(Connection conn, int studentId) throws SQLException {
        List<Registration> list = new ArrayList<>();
        String sql = "SELECT * FROM registration WHERE student_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Registration(
                        rs.getInt("reg_id"),
                        rs.getInt("student_id"),
                        rs.getString("course_name"),
                        rs.getDouble("fees_paid")
                    ));
                }
            }
        }
        return list;
    }

    //  Update fee for a specific student + course 
    public boolean updateFee(Connection conn, int studentId, String courseName, double newFee) throws SQLException {
        String sql = "UPDATE registration SET fees_paid = ? WHERE student_id = ? AND course_name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newFee);
            ps.setInt(2, studentId);
            ps.setString(3, courseName);
            return ps.executeUpdate() > 0;
        }
    }

    //  Delete one registration row 
    public boolean cancelRegistration(Connection conn, int studentId, String courseName) throws SQLException {
        String sql = "DELETE FROM registration WHERE student_id = ? AND course_name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setString(2, courseName);
            return ps.executeUpdate() > 0;
        }
    }

    // Delete ALL registrations for a student (used in delete-student tx) 
    public void deleteAllByStudentId(Connection conn, int studentId) throws SQLException {
        String sql = "DELETE FROM registration WHERE student_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.executeUpdate();
        }
    }

    //  Report: students who paid above a threshold 
    public List<String[]> getHighPayingStudents(Connection conn, double minFee) throws SQLException {
        List<String[]> results = new ArrayList<>();
        String sql = "SELECT s.id, s.name, s.branch, r.course_name, r.fees_paid "
                   + "FROM student s "
                   + "JOIN registration r ON s.id = r.student_id "
                   + "WHERE r.fees_paid > ? "
                   + "ORDER BY r.fees_paid DESC";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, minFee);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    results.add(new String[]{
                        String.valueOf(rs.getInt("id")),
                        rs.getString("name"),
                        rs.getString("branch"),
                        rs.getString("course_name"),
                        String.format("%.2f", rs.getDouble("fees_paid"))
                    });
                }
            }
        }
        return results;
    }

    // Report: how many students per course 
    public List<String[]> getCourseWiseCount(Connection conn) throws SQLException {
        List<String[]> results = new ArrayList<>();
        String sql = "SELECT course_name, COUNT(student_id) AS student_count "
                   + "FROM registration "
                   + "GROUP BY course_name "
                   + "ORDER BY student_count DESC";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                results.add(new String[]{
                    rs.getString("course_name"),
                    String.valueOf(rs.getInt("student_count"))
                });
            }
        }
        return results;
    }
}
