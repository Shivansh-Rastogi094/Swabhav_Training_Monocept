package predicate;
import java.util.function.Predicate;
public class Q1 {

    public static void main(String[] args) {

	        Predicate<Integer> isOdd = num -> num % 2 != 0;
	        System.out.println("Odd numbers from 1 to 10:");

	        for (int i = 1; i <= 10; i++) {
	            if (isOdd.test(i)) {
	                System.out.print(i + " ");
	            }
	        }
	    }
	}