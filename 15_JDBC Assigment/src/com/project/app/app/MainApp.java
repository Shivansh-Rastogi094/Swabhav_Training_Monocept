package com.project.app.app;

//import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.project.app.exception.*;
import com.project.app.service.StudentService;

public class MainApp {

	private static final StudentService service = new StudentService();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = -1;
		do {
			try {
				printMenu();
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine();
				handleChoice(choice);
			} catch (InputMismatchException e) {
				System.out.println("[ERROR] Invalid input. Please enter a number between 1 and 11.");
				sc.nextLine();
			}
		} while (choice != 11);

		sc.close();
	}

	//  Route menu choice to the correct service call 
	private static void handleChoice(int choice) {
		try {
			switch (choice) {

			//  1. Add Student 
			case 1: {
				System.out.print("Enter Student ID   : ");
				int id = readInt();
				System.out.print("Enter Name         : ");
				String name = sc.nextLine();
				System.out.print("Enter Age          : ");
				int age = readInt();
				System.out.print("Enter Branch       : ");
				String branch = sc.nextLine();
				service.addStudent(id, name, age, branch);
				break;
			}

			// 2. Register for Course 
			case 2: {
				System.out.print("Enter Student ID   : ");
				int sid = readAndValidateStudentId();
				System.out.print("Enter Course Name  : ");
				String course = sc.nextLine();
				System.out.print("Enter Fees Paid    : ");
				double fees = readDouble();
				service.registerForCourse(sid, course, fees);
				break;
			}

			//  3. View All Students with Courses 
			case 3: {
				service.viewAllStudentsWithCourses();
				break;
			}

			//  4. Search Student by ID 
			case 4: {
				System.out.print("Enter Student ID   : ");
				int id = readAndValidateStudentId();
				service.searchStudentById(id);
				break;
			}

			//  5. Update Student Details
			case 5: {
				System.out.print("Enter Student ID   : ");
				int id = readAndValidateStudentId();
				System.out.print("Enter New Name     : ");
				String name = sc.nextLine();
				System.out.print("Enter New Branch   : ");
				String branch = sc.nextLine();
				service.updateStudent(id, name, branch);
				break;
			}

			//  6. Update Course Fee 
			case 6: {
				System.out.print("Enter Student ID   : ");
				int sid = readAndValidateStudentId();
				System.out.print("Enter Course Name  : ");
				String course = sc.nextLine();
				System.out.print("Enter New Fee      : ");
				double fee = readDouble();
				service.updateCourseFee(sid, course, fee);
				break;
			}

			//  7. Cancel Registration 
			case 7: {
				System.out.print("Enter Student ID   : ");
				int sid = readAndValidateStudentId();
				System.out.print("Enter Course Name  : ");
				String course = sc.nextLine();
				service.cancelRegistration(sid, course);
				break;
			}

			//  8. Delete Student 
			
			case 8: {
				System.out.print("Enter Student ID   : ");
				int id = readAndValidateStudentId();
				service.deleteStudent(id);
				break;
			}

			//  9. High Paying Students Report 
			case 9: {
				System.out.print("Enter Minimum Fees : ");
				double minFee = readDouble();
				service.getHighPayingStudents(minFee);
				break;
			}

			//  10. Course-wise Student Count
			case 10: {
				service.getCourseWiseStudentCount();
				break;
			}
			

			//  11. Exit 
			case 11: {
				System.out.println("\nExiting system... Goodbye!");
				break;
			}

			default:
				System.out.println("[ERROR] Invalid choice. Please enter a number between 1 and 11.");
			}

			// Custom exception handlers 
		} catch (InvalidInputException e) {
			System.out.println("[VALIDATION ERROR] " + e.getMessage());
		} catch (StudentNotFoundException e) {
			System.out.println("[NOT FOUND] " + e.getMessage());
		} catch (DuplicateStudentException e) {
			System.out.println("[DUPLICATE] " + e.getMessage());
		} catch (DuplicateRegistrationException e) {
			System.out.println("[DUPLICATE] " + e.getMessage());
		} catch (RegistrationNotFoundException e) {
			System.out.println("[NOT FOUND] " + e.getMessage());
		} catch (DatabaseException e) {
			System.out.println("[DATABASE ERROR] " + e.getMessage());
			if (e.getCause() != null) {
				System.out.println("  Caused by: " + e.getCause().getMessage());
			}
		} catch (Exception e) {
			System.out.println("[SQL ERROR] " + e.getMessage());
		}
	}

	// Safe numeric input helpers 
	private static int readInt() {
		while (true) {
			try {
				int val = sc.nextInt();
				sc.nextLine();
				return val;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("[ERROR] Please enter a valid integer: ");
			}
		}
	}

	private static double readDouble() {
		while (true) {
			try {
				double val = sc.nextDouble();
				sc.nextLine();
				return val;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("[ERROR] Please enter a valid number: ");
			}
		}
	}
	
	
	private static int readAndValidateStudentId() {
	    while (true) {
	        //System.out.print("Enter Student ID   : ");
	        int id = readInt();
	        try {
	            if (service.doesStudentExist(id)) {
	                return id; // valid — proceed
	            }
	            System.out.println("[NOT FOUND] No student found with ID " + id + ". Try again.");
	        } catch (DatabaseException e) {
	            System.out.println("[DATABASE ERROR] " + e.getMessage());
	            return -1; // DB is down — bail out gracefully
	        }
	    }
	}


	//  Console menu 
	private static void printMenu() {
		System.out.println("    Student Course Registration System\n");
		System.out.println("  1.  Add Student");
		System.out.println("  2.  Register for Course");
		System.out.println("  3.  View All Students with Courses");
		System.out.println("  4.  Search Student by ID");
		System.out.println("  5.  Update Student Details");
		System.out.println("  6.  Update Course Fee");
		System.out.println("  7.  Cancel Registration");
		System.out.println("  8.  Delete Student");
		System.out.println("  9.  High Paying Students Report");
		System.out.println("  10. Course-wise Student Count");
		System.out.println("  11. Exit");
	}
}
