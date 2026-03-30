package basic;
import java.util.Scanner;
import java.util.Random;

public class q13NumberGuess {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(100) + 1; 
        int guess = 0;
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100");

        while(guess != number) {

            System.out.print("Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if(guess > number) {
                System.out.println("Too high!");
            }
            else if(guess < number) {
                System.out.println("Too low!");
            }
            else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts.");
            }
        }

        sc.close();
    }
}