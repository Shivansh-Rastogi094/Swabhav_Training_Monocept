package predicate;

import java.util.*;
import java.util.function.Predicate;
public class Q2 {

    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter number of strings: ");
	        int n = sc.nextInt();
	        sc.nextLine(); 

	        List<String> list = new ArrayList<>();

	        System.out.println("Enter strings (type 'null' for null value):");

	        for (int i = 0; i < n; i++) {
	            String input = sc.nextLine();
	            if (input.equalsIgnoreCase("null")) {
	                list.add(null);
	            } else {
	                list.add(input);
	            }
	        }

	        Predicate<String> isValid = str -> str != null && !str.trim().isEmpty();

	        System.out.println("\nValid strings:");

	        for (String s : list) {
	            if (isValid.test(s)) {
	                System.out.println(s);
	            }
	        }

	        sc.close();
	    }
	}
	