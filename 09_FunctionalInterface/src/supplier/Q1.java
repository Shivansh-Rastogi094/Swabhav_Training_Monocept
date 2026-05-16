package supplier;

import java.util.*;
import java.util.function.Supplier;
public class Q1 {
	
	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int count;

	     
	        while (true) {
	            System.out.print("Enter how many random numbers (1 to 5): ");

	            if (sc.hasNextInt()) {
	                count = sc.nextInt();

	                if (count >= 1 && count <= 5) {
	                    break;
	                } else {
	                    System.out.println("Please enter a number between 1 and 5.");
	                }
	            } else {
	                System.out.println("Invalid input! Enter an integer.");
	                sc.next(); 
	            }
	        }

	      
	        Supplier<Double> randomSupplier = () -> Math.random();

	        System.out.println("\nRandom Numbers:");
	        for (int i = 0; i < count; i++) {
	            System.out.println(randomSupplier.get());
	        }

	        sc.close();
	    }
	}	
