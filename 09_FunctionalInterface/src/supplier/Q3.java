package supplier;

import java.util.*;
import java.util.function.Supplier;
public class Q3 {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        int n;
	        while (true) {
	            System.out.print("Enter number of products: ");
	            if (sc.hasNextInt()) {
	                n = sc.nextInt();
	                sc.nextLine();
	                if (n > 0) break;
	                else System.out.println("Enter a positive number.");
	            } else {
	                System.out.println("Invalid input! Enter an integer.");
	                sc.next();
	            }
	        }

	        Supplier<List<String>> productSupplier = () -> Arrays.asList(
	                "Laptop", "Phone", "Tablet", "Headphones", "Smartwatch"
	        );

	        List<String> defaultProducts = productSupplier.get();
	        List<String> products = new ArrayList<>();

	        System.out.println("Enter product names:");

	        for (int i = 0; i < n; i++) {
	            String product;
	            while (true) {
	                product = sc.nextLine();
	                if (!product.trim().isEmpty()) break;
	                else System.out.println("Product name cannot be empty. Re-enter:");
	            }

	            if (i < defaultProducts.size()) {
	                products.add(defaultProducts.get(i));
	            } else {
	                products.add(product);
	            }
	        }

	        System.out.println("\nProduct List:");
	        for (String p : products) {
	            System.out.println(p);
	        }

	        sc.close();
	    }
	}