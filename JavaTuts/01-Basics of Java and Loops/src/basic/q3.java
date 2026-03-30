package basic;
import java.util.Scanner;
public class q3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
//	Reverse a number
		System.out.print("Enter your number:");
		int n= sc.nextInt();
		int d,rev=0;
		while(n>0) {
			d=n%10;
			rev=rev*10+d;
			n=n/10;
		}
		
		System.out.println("Reversed Number:"+ rev);
		sc.close();
	}
}
