package predicate;

import java.util.*;
import java.util.function.Predicate;
public class Q3 {
	
	    static class Student {
	        String name;
	        int marks;

	        Student(String name, int marks) {
	            this.name = name;
	            this.marks = marks;
	        }
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of students: ");
	        int n = sc.nextInt();
	        sc.nextLine(); 
	        List<Student> students = new ArrayList<>();

	        for (int i = 0; i < n; i++) {
	            System.out.println("\nEnter details for student " + (i + 1));

	            System.out.print("Name: ");
	            String name = sc.nextLine();

	            int marks;
	            while (true) {
	                System.out.print("Marks: ");
	                if (sc.hasNextInt()) {
	                    marks = sc.nextInt();
	                    sc.nextLine(); 
	                    break;
	                } else {
	                    System.out.println("Invalid input! Enter integer marks.");
	                    sc.next(); // discard invalid input
	                }
	            }

	            students.add(new Student(name, marks));
	        }

	        // Predicate for passing students
	        Predicate<Student> isPassed = s -> s.marks >= 40;

	        System.out.println("\nPassing Students:");

	        for (Student s : students) {
	            if (isPassed.test(s)) {
	                System.out.println(s.name + " - " + s.marks);
	            }
	        }

	        sc.close();
	    }
	}
