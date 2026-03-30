package basic;
import java.util.Scanner;
public class q12PrimePatterns {
	static boolean isPrime(int n) {
		int count=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0)
				count++;
		}
		if(count==2)
			return true;
		else
			return false;
	}
	 public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter rows: ");
	        int rows = sc.nextInt();

	        int num = 2;
	        int count = 0;

	        while(count < rows) {

	            if(isPrime(num)) {

	                for(int i = 1; i <= num; i++) {
	                    System.out.print("* ");
	                }

	                System.out.println();
	                count++;
	            }

	            num++;
	        }
	    }
	}

