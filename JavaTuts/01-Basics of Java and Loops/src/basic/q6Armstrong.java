package basic;

import java.util.Scanner;

public class q6Armstrong {

    static int countDigits(int n) {
        int count = 0;

        while(n > 0) {
            count++;
            n = n / 10;
        }

        return count;
    }

    static int armstrongSum(int n) {

        int digits = countDigits(n);
        int sum = 0;
        int temp = n;

        while(temp > 0) {

            int d = temp % 10;

            sum += Math.pow(d, digits);

            temp = temp / 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        if(armstrongSum(num) == num)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong");

    }
}