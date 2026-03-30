package basic;
import java.util.Scanner;
public class q5 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
//	Check a number is palindrome or not 
		System.out.print("Enter your number:");
		int n= sc.nextInt();
		int temp=n;
		int d,rev=0;
		while(n>0) {
			d=n%10;
			rev=rev*10+d;
			n=n/10;
		}
		if(rev==temp)
			System.out.println(rev+"  is a Palindrome Number");
		else 
			System.out.println(rev+"  is not a Palindrome Number");
		sc.close();
	}
}
