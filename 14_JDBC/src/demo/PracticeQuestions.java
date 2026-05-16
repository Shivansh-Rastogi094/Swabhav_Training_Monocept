package demo;

import java.sql.*;
import java.util.Scanner;

public class PracticeQuestions {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Insert Student");
			System.out.println("2. Batch Insert (5 Students)");
			System.out.println("3. Display All Students");
			System.out.println("4. Get Student by ID");
			System.out.println("5. Students by Branch");
			System.out.println("6. Marks > Value");
			System.out.println("7. Age Between Range");
			System.out.println("8. Update Name by ID");
			System.out.println("9. Update Branch & Marks");
			System.out.println("10. Increase Marks by Branch");
			System.out.println("11. Delete by ID");
			System.out.println("12. Delete Marks Below");
			System.out.println("0. Exit");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				insertStudent();
				break;
			case 2:
				batchInsert();
				break;
			case 3:
				displayAll();
				break;
			case 4:
				getById();
				break;
			case 5:
				getByBranch();
				break;
			case 6:
				marksGreater();
				break;
			case 7:
				ageBetween();
				break;
			case 8:
				updateName();
				break;
			case 9:
				updateBranchMarks();
				break;
			case 10:
				increaseMarks();
				break;
			case 11:
				deleteById();
				break;
			case 12:
				deleteBelowMarks();
				break;
			case 0:
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}
	}

	// 1. Insert Student
	static void insertStudent() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter id: ");
			ps.setInt(1, sc.nextInt());
			sc.nextLine();

			System.out.print("Enter name: ");
			ps.setString(2, sc.nextLine());

			System.out.print("Enter age: ");
			ps.setInt(3, sc.nextInt());
			sc.nextLine();

			System.out.print("Enter branch: ");
			ps.setString(4, sc.nextLine());

			System.out.print("Enter marks: ");
			ps.setInt(5, sc.nextInt());

			ps.executeUpdate();
			System.out.println("Inserted successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2. Batch Insert
	static void batchInsert() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			for (int i = 1; i <= 5; i++) {
				System.out.println("Enter details for student " + i);

				System.out.print("ID: ");
				ps.setInt(1, sc.nextInt());
				sc.nextLine();

				System.out.print("Name: ");
				ps.setString(2, sc.nextLine());

				System.out.print("Age: ");
				ps.setInt(3, sc.nextInt());
				sc.nextLine();

				System.out.print("Branch: ");
				ps.setString(4, sc.nextLine());

				System.out.print("Marks: ");
				ps.setInt(5, sc.nextInt());

				ps.addBatch();
			}

			ps.executeBatch();
			System.out.println("Batch inserted successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 3. Display All
	static void displayAll() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "SELECT * FROM students";
			ResultSet rs = con.prepareStatement(sql).executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3) + " | "
						+ rs.getString(4) + " | " + rs.getInt(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 4. Get by ID
	static void getById() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "SELECT * FROM students WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter id: ");
			ps.setInt(1, sc.nextInt());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getInt(3) + " | "
						+ rs.getString(4) + " | " + rs.getInt(5));
			} else {
				System.out.println("Student not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 5. By Branch
	static void getByBranch() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "SELECT * FROM students WHERE branch=?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter branch: ");
			sc.nextLine();
			ps.setString(1, sc.nextLine());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 6. Marks Greater
	static void marksGreater() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "SELECT * FROM students WHERE grade > ?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter marks: ");
			ps.setInt(1, sc.nextInt());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 7. Age Between
	static void ageBetween() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "SELECT * FROM students WHERE age BETWEEN ? AND ?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter min age: ");
			ps.setInt(1, sc.nextInt());

			System.out.print("Enter max age: ");
			ps.setInt(2, sc.nextInt());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 8. Update Name
	static void updateName() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "UPDATE students SET name=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter id: ");
			ps.setInt(2, sc.nextInt());
			sc.nextLine();

			System.out.print("Enter new name: ");
			ps.setString(1, sc.nextLine());

			ps.executeUpdate();
			System.out.println("Updated!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 9. Update Branch & Marks
	static void updateBranchMarks() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "UPDATE students SET branch=?, grade=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter branch: ");
			sc.nextLine();
			ps.setString(1, sc.nextLine());

			System.out.print("Enter marks: ");
			ps.setInt(2, sc.nextInt());

			System.out.print("Enter id: ");
			ps.setInt(3, sc.nextInt());

			ps.executeUpdate();
			System.out.println("Updated!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 10. Increase Marks
	static void increaseMarks() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "UPDATE students SET grade = grade + ? WHERE branch=?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter increment: ");
			ps.setInt(1, sc.nextInt());
			sc.nextLine();

			System.out.print("Enter branch: ");
			ps.setString(2, sc.nextLine());

			ps.executeUpdate();
			System.out.println("Marks updated!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 11. Delete by ID
	static void deleteById() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "DELETE FROM students WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter id: ");
			ps.setInt(1, sc.nextInt());

			ps.executeUpdate();
			System.out.println("Deleted!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 12. Delete Below Marks
	static void deleteBelowMarks() {
		try (Connection con = JDBCDemo.getConnection()) {

			String sql = "DELETE FROM students WHERE grade < ?";
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.print("Enter threshold marks: ");
			ps.setInt(1, sc.nextInt());

			ps.executeUpdate();
			System.out.println("Deleted records!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}