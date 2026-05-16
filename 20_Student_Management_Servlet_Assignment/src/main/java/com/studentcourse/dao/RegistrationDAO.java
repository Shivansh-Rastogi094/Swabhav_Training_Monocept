package com.studentcourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.studentcourse.model.Registration;
import com.studentcourse.util.DBConnection;

public class RegistrationDAO {

    public int getRegistrationCount() {
        String query = "SELECT COUNT(*) FROM registrations";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean hasRegistrations(int studentId) {
        String query = "SELECT COUNT(*) FROM registrations WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean hasCourseRegistrations(int courseId) {
        String query = "SELECT COUNT(*) FROM registrations WHERE course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Registration> getAllRegistrations() {
        List<Registration> registrations = new ArrayList<>();
        String query = "SELECT r.*, s.student_name, c.course_name FROM registrations r " +
                       "JOIN students s ON r.student_id = s.student_id " +
                       "JOIN courses c ON r.course_id = c.course_id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Registration r = new Registration();
                r.setRegistrationId(rs.getInt("registration_id"));
                r.setStudentId(rs.getInt("student_id"));
                r.setCourseId(rs.getInt("course_id"));
                r.setRegistrationDate(rs.getTimestamp("registration_date").toString());
                r.setStatus(rs.getString("status"));
                r.setStudentName(rs.getString("student_name"));
                r.setCourseName(rs.getString("course_name"));
                registrations.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }

    public boolean isAlreadyRegistered(int studentId, int courseId) {
        String query = "SELECT COUNT(*) FROM registrations WHERE student_id = ? AND course_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addRegistration(int studentId, int courseId) {
        String query = "INSERT INTO registrations (student_id, course_id, status, registration_date) VALUES (?, ?, 'Active', CURRENT_TIMESTAMP)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteRegistration(int id) {
        String query = "DELETE FROM registrations WHERE registration_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Registration> getRegistrationsByCourse() {
        List<Registration> registrations = new ArrayList<>();
        String query = "SELECT r.*, s.student_name, c.course_name FROM registrations r " +
                       "JOIN students s ON r.student_id = s.student_id " +
                       "JOIN courses c ON r.course_id = c.course_id " +
                       "ORDER BY c.course_name, s.student_name";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Registration r = new Registration();
                r.setRegistrationId(rs.getInt("registration_id"));
                r.setStudentName(rs.getString("student_name"));
                r.setCourseName(rs.getString("course_name"));
                r.setRegistrationDate(rs.getTimestamp("registration_date").toString());
                r.setStatus(rs.getString("status"));
                registrations.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }
}
