package basic;
import java.util.Scanner;
public class q4 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
//	Sum of digits of a number
		System.out.print("Enter your number:");
		int n= sc.nextInt();
		int d,sum=0;
		while(n>0) {
			d=n%10;
			sum=sum+d;
			n=n/10;
		}
		
		System.out.println("Sum of numbers:"+ sum);
		sc.close();
	}
}
