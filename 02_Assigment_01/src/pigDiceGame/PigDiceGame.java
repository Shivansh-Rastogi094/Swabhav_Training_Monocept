package pigDiceGame;
import java.util.Random;
import java.util.Scanner;

public class PigDiceGame {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static int totalScore = 0;  
    static int turn = 0;

    static int roll() {
        return rand.nextInt(6) + 1;
    }

    static char choice() {
        while(true) {
            System.out.print("Roll or hold? (r/h): ");
            String input = sc.nextLine().toLowerCase().trim();

            if(input.length() == 0) {
                System.out.println("Invalid input. Please enter r or h.");
                continue;
            }

            if(input.length() > 1) {
                System.out.println("Invalid input. Please enter r or h.");
                continue;
            }

            if(input.equals("r") || input.equals("h"))
                return input.charAt(0);

            System.out.println("Invalid input. Please enter r or h.");
        }
    }

    static void play() {

        while(true) {

            char playerChoice = choice();

            if(playerChoice == 'r') {

                int dice = roll();
                System.out.println("Dice: " + dice);

                if(dice == 1) {
                    System.out.println("Turn Over, No Score!");
                    return;
                }

                totalScore += dice;   
                System.out.println("Total Score: " + totalScore);

                if(totalScore >= 20)
                    return;
            }

            else if(playerChoice == 'h') {
                System.out.println("Total Score: " + totalScore);
                return;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Let's Play PIG !!");

        while(totalScore < 20) {

            turn++;
            System.out.println("Turn: " + turn);
            play();
        }

        System.out.println("Game Over, You Won in " + turn + " turns");
        sc.close();
    }
}