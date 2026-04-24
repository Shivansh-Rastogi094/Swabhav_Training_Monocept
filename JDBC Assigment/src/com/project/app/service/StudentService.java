package com.project.app.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.project.app.dao.RegistrationDAO;
import com.project.app.dao.StudentDAO;
import com.project.app.exception.DatabaseException;
import com.project.app.exception.DuplicateRegistrationException;
import com.project.app.exception.DuplicateStudentException;
import com.project.app.exception.InvalidInputException;
import com.project.app.exception.RegistrationNotFoundException;
import com.project.app.exception.StudentNotFoundException;
import com.project.app.model.Registration;
import com.project.app.model.Student;
import com.project.app.util.DBUtil;

public class StudentService {

	private final StudentDAO studentDAO = new StudentDAO();
	private final RegistrationDAO registrationDAO = new RegistrationDAO();
	
	// existence check
	public boolean doesStudentExist(int id) throws DatabaseException {
	    try (Connection conn = DBUtil.getConnection()) {
	        return studentDAO.getStudentById(conn, id) != null;
	    } catch (SQLException e) {
	        throw new DatabaseException("Failed to verify student ID " + id + ".", e);
	    }
	}

	// 1. ADD STUDENT
	public void addStudent(int id, String name, int age, String branch)
			throws InvalidInputException, DuplicateStudentException, DatabaseException {

		// Input validation
		if (id <= 0)
			throw new InvalidInputException("Student ID must be greater than 0.");
		if (name == null || name.isBlank())
			throw new InvalidInputException("Student name cannot be empty.");
		if (age <= 0)
			throw new InvalidInputException("Age must be greater than 0. Received: " + age);

		try (Connection conn = DBUtil.getConnection()) { 
			studentDAO.addStudent(conn, new Student(id, name.trim(), age, branch));
			System.out.println("[SUCCESS] Student added successfully.");
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) { // MySQL: duplicate entry
				throw new DuplicateStudentException(id);
			}
			throw new DatabaseException("Failed to add student.", e);
		}
	}

	// 2. REGISTER FOR COURSE | TRANSACTION
	public void registerForCourse(int studentId, String courseName, double fees)
			throws InvalidInputException, StudentNotFoundException, DuplicateRegistrationException, DatabaseException {

		// Input validation
		if (courseName == null || courseName.isBlank())
			throw new InvalidInputException("Course name cannot be empty.");
		if (fees <= 0)
			throw new InvalidInputException("Fees must be greater than 0. Received: " + fees);

		Connection conn = null;   
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false); // BEGIN TRANSACTION

			// Check 1: student must exist
			Student student = studentDAO.getStudentById(conn, studentId);
			if (student == null) {
				conn.rollback();
				throw new StudentNotFoundException(studentId);
			}

			// Check 2: no duplicate registration
			if (registrationDAO.isDuplicateRegistration(conn, studentId, courseName)) {
				conn.rollback();
				throw new DuplicateRegistrationException(studentId, courseName);
			}

			// All checks passed — insert
			registrationDAO.addRegistration(conn, new Registration(0, studentId, courseName.trim(), fees));
			conn.commit(); // COMMIT TRANSACTION
			System.out.println(
					"[SUCCESS] Student ID " + studentId + " registered for '" + courseName + "' | Fees: Rs." + fees);

		} catch ( StudentNotFoundException | DuplicateRegistrationException e) {
			// Re-throw business exceptions as-is (roll back already done above)
			throw e;
		} catch (SQLException e) {
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException ex) {
				/* best effort */ }
			throw new DatabaseException("Registration transaction failed.", e);
		} finally {
			try {
				if (conn != null) {
					conn.setAutoCommit(true);
					conn.close();
				}
			} catch (SQLException e) {
				 }
		}
	}

	// 3. VIEW ALL STUDENTS WITH REGISTRATIONS (LEFT JOIN)
	public void viewAllStudentsWithCourses() throws DatabaseException {
		try (Connection conn = DBUtil.getConnection()) {
			List<String[]> results = studentDAO.getAllStudentsWithRegistrations(conn);
			if (results.isEmpty()) {
				System.out.println("[INFO] No students found in the system.");
				return;
			}
			System.out.println("\n");
			System.out.printf("%-6s %-20s %-5s %-25s %-25s %-10s%n", "ID", "Name", "Age", "Branch", "Course",
					"Fees Paid");
			System.out.println("\n");
			for (String[] row : results) {
				System.out.printf("%-6s %-20s %-5s %-25s %-25s %-10s%n", row[0], row[1], row[2], row[3], row[4],
						row[5]);
			}
			System.out.println("\n");
		} catch (SQLException e) {
			throw new DatabaseException("Failed to fetch student records.", e);
		}
	}

	// 4. SEARCH STUDENT BY ID
	public void searchStudentById(int id) throws StudentNotFoundException, DatabaseException {

		try (Connection conn = DBUtil.getConnection()) {
			Student s = studentDAO.getStudentById(conn, id);
			if (s == null)
				throw new StudentNotFoundException(id);

			System.out.println("\n--- Student Details ---");
			System.out.println(s);

			List<Registration> regs = registrationDAO.getRegistrationsByStudentId(conn, id);
			if (regs.isEmpty()) {
				System.out.println("[INFO] This student has no course registrations.");
			} else {
				System.out.println("\n--- Registered Courses ---");
				regs.forEach(System.out::println);
			}
		} catch (StudentNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Failed to search for student ID " + id + ".", e);
		}
	}

	// 5. UPDATE STUDENT DETAILS
	public void updateStudent(int id, String newName, String newBranch)
			throws InvalidInputException, StudentNotFoundException, DatabaseException {

		if (newName == null || newName.isBlank())
			throw new InvalidInputException("Updated name cannot be empty.");

		try (Connection conn = DBUtil.getConnection()) {
			if (studentDAO.getStudentById(conn, id) == null)
				throw new StudentNotFoundException(id);

			studentDAO.updateStudent(conn, id, newName.trim(), newBranch);
			System.out.println("[SUCCESS] Student ID " + id + " updated successfully.");
		} catch (StudentNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Failed to update student ID " + id + ".", e);
		}
	}

	// 6. UPDATE COURSE FEE
	public void updateCourseFee(int studentId, String courseName, double newFee)
			throws InvalidInputException, RegistrationNotFoundException, DatabaseException {

		if (newFee <= 0)
			throw new InvalidInputException("New fee must be greater than 0. Received: " + newFee);
		if (courseName == null || courseName.isBlank())
			throw new InvalidInputException("Course name cannot be empty.");

		try (Connection conn = DBUtil.getConnection()) {
			boolean updated = registrationDAO.updateFee(conn, studentId, courseName, newFee);
			if (!updated)
				throw new RegistrationNotFoundException(studentId, courseName);
			System.out.println("[SUCCESS] Fee updated to Rs." + newFee + " for course '" + courseName + "'.");
		} catch (RegistrationNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Failed to update course fee.", e);
		}
	}

	// 7. CANCEL REGISTRATION
	public void cancelRegistration(int studentId, String courseName)
			throws RegistrationNotFoundException, DatabaseException {

		try (Connection conn = DBUtil.getConnection()) {
			boolean cancelled = registrationDAO.cancelRegistration(conn, studentId, courseName);
			if (!cancelled)
				throw new RegistrationNotFoundException(studentId, courseName);

			System.out.println("[SUCCESS] Registration cancelled. Student record remains intact.");
		} catch (RegistrationNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw new DatabaseException("Failed to cancel registration.", e);
		}
	}
	
	// 8. DELETE STUDENT | TRANSACTION
			public void deleteStudent(int id) throws StudentNotFoundException, DatabaseException {

				Connection conn = null;
				try {
					conn = DBUtil.getConnection();
					conn.setAutoCommit(false); // BEGIN TRANSACTION

					if (studentDAO.getStudentById(conn, id) == null) {
						conn.rollback();
						throw new StudentNotFoundException(id);
					}

					// Step 1: Remove all registrations 
					registrationDAO.deleteAllByStudentId(conn, id);

					// Step 2: Remove the student
					studentDAO.deleteStudent(conn, id);

					conn.commit(); // COMMIT TRANSACTION
					System.out.println("[SUCCESS] Student ID " + id + " and all their registrations deleted successfully.");

				} catch (StudentNotFoundException e) {
					throw e;
				} catch (SQLException e) {
					try {
						if (conn != null)
							conn.rollback();
					} catch (SQLException ex) {
					}
					throw new DatabaseException("Delete student transaction failed.", e);
				} finally {
					try {
						if (conn != null) {
							conn.setAutoCommit(true);
							conn.close();
						}
					} catch (SQLException e) {
						/* ignore */ }
				}
			}

			// 9. REPORT: HIGH PAYING STUDENTS
			public void getHighPayingStudents(double minFee) throws InvalidInputException, DatabaseException {

				if (minFee < 0)
					throw new InvalidInputException("Minimum fee filter cannot be negative. Received: " + minFee);

				try (Connection conn = DBUtil.getConnection()) {
					List<String[]> results = registrationDAO.getHighPayingStudents(conn, minFee);
					if (results.isEmpty()) {
						System.out.println("[INFO] No students found with fees paid above Rs." + minFee);
						return;
					}
					System.out.println("\n");
					System.out.printf("%-6s %-20s %-15s %-28s %-10s%n", "ID", "Name", "Branch", "Course", "Fees Paid");
					System.out.println("\n");
					for (String[] row : results) {
						System.out.printf("%-6s %-20s %-15s %-28s %-10s%n", row[0], row[1], row[2], row[3], row[4]);
					}
					System.out.println("\n");
				} catch (SQLException e) {
					throw new DatabaseException("Failed to generate high paying students report.", e);
				}
			}

			// 10. REPORT: COURSE-WISE STUDENT COUNT
			public void getCourseWiseStudentCount() throws DatabaseException {
				try (Connection conn = DBUtil.getConnection()) {
					List<String[]> results = registrationDAO.getCourseWiseCount(conn);
					if (results.isEmpty()) {
						System.out.println("[INFO] No course registrations found.");
						return;
					}
					System.out.println("\n");
					System.out.printf("%-35s %-10s%n", "Course Name", "Students");
					System.out.println("\n");
					for (String[] row : results) {
						System.out.printf("%-35s %-10s%n", row[0], row[1]);
					}
					System.out.println("\n");
				} catch (SQLException e) {
					throw new DatabaseException("Failed to generate course-wise count report.", e);
				}
			}

	}
