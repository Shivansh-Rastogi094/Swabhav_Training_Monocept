package Game;

import java.util.Scanner;
import java.util.Random;

public class NumberGuess {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int choice = 0;

		do {

			System.out.println("\n------ NUMBER GUESS GAME ------");
			System.out.println("1. Start Game");
			System.out.println("2. Exit");
			System.out.print("Enter your choice: ");

		
			if (!sc.hasNextInt()) {
				System.out.println("Invalid input! Enter a number.");
				sc.next();
				continue;
			}

			choice = sc.nextInt();

			switch (choice) {

			case 1:

				int number = rand.nextInt(100) + 1;
				int guess = -1;
				int attempts = 0;

				System.out.println("\nGuess the number between 1 and 100");

				while (guess != number) {

					System.out.print("Enter your guess: ");

					
					if (!sc.hasNextInt()) {
						System.out.println("Invalid input! Enter a number.");
						sc.next();
						continue;
					}

					guess = sc.nextInt();


					if (guess < 1 || guess > 100) {
						System.out.println("Please enter number between 1 and 100.");
						continue;
					}

					attempts++;

					if (guess > number) {
						System.out.println("Too High!");
					} else if (guess < number) {
						System.out.println("Too Low!");
					} else {
						System.out.println("Correct! You guessed it in " + attempts + " attempts.");
					}
				}

				break;

			case 2:
				System.out.println("Thank you for playing!");
				break;

			default:
				System.out.println("Invalid choice! Please select 1 or 2.");
			}

		} while (choice != 2);

		sc.close();
	}
}