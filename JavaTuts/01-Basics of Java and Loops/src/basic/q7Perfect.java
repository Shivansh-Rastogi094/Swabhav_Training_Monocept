package basic;

import java.util.Scanner;

public class q7Perfect {
static int countFactors(int num) {
	int count=0;
	for(int i=1;i<=num;i++) {
		if(num%i==0)
			count++;
	}
	return count;
}

static boolean isPerfect(int num) {
	int factors=countFactors(num);
	if(factors==2)
		return true;
	else
		return false;
}



	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n;
		System.out.println("Enter a number");
		n=sc.nextInt();
		if(isPerfect(n))
			System.out.println(n+" is a Perfect number");
		else
			System.out.println(n+" is not a Perfect number");
		sc.close();
	}
}
