package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nTIC TAC TOE");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            try {

                if (choice == 1) {

                    System.out.print("Enter Player 1 name: ");
                    String p1 = sc.nextLine();

                    System.out.print("Enter Player 2 name: ");
                    String p2 = sc.nextLine();

                    GameManager game = new GameManager(p1, p2, false);
                    game.startGame();
                }

                else if (choice == 2) {

                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    GameManager game = new GameManager(name, "Computer", true);
                    game.startGame();
                }

                else if (choice == 3) {
                    System.out.println("Goodbye!");
                    break;
                }

                else {
                    throw new Exception("Invalid option");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}