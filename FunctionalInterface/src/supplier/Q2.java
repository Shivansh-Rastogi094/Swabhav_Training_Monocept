package supplier;

import java.util.*;
import java.util.function.Supplier;
public class Q2 {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        Supplier<String> defaultCity = () -> "Pune";

	        String city;

	        while (true) {
	            System.out.print("Enter your city (press Enter to use default): ");
	            String input = sc.nextLine();

	            if (input == null || input.trim().isEmpty()) {
	                city = defaultCity.get();
	                break;
	            }

	            if (input.matches("[a-zA-Z ]+")) {
	                city = input.trim();
	                break;
	            } else {
	                System.out.println("Invalid city name! Use only letters.");
	            }
	        }

	        System.out.println("Selected City: " + city);

	        sc.close();
	    }
	}
