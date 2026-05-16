package facadeDesign_TicTacToe;
import java.util.Scanner;
public class TicTacToeFacade {

	    private Scanner sc = new Scanner(System.in);

	    public void startPlayerVsPlayer() {
	        try {
	            System.out.print("Enter Player 1 name: ");
	            String p1 = sc.nextLine();

	            System.out.print("Enter Player 2 name: ");
	            String p2 = sc.nextLine();

	            GameManager game = new GameManager(p1, p2, false);
	            game.startGame();

	        } catch (Exception e) {
	            System.out.println("Error starting game: " + e.getMessage());
	        }
	    }

	    public void startPlayerVsComputer() {
	        try {
	            System.out.print("Enter your name: ");
	            String name = sc.nextLine();

	            GameManager game = new GameManager(name, "Computer", true);
	            game.startGame();

	        } catch (Exception e) {
	            System.out.println("Error starting game: " + e.getMessage());
	        }
	    }

	    public boolean handleMenuChoice(int choice) {
	        switch (choice) {
	            case 1:
	                startPlayerVsPlayer();
	                return true;
	            case 2:
	                startPlayerVsComputer();
	                return true;
	            case 3:
	                System.out.println("Goodbye!");
	                return false; // signals exit
	            default:
	                System.out.println("Invalid option. Please choose 1, 2, or 3.");
	                return true;
	        }
	    }

	    public void showMenu() {
	        System.out.println("\nTIC TAC TOE");
	        System.out.println("1. Player vs Player");
	        System.out.println("2. Player vs Computer");
	        System.out.println("3. Exit");
	    }

	    public void closeResources() {
	        sc.close();
	    }
	}
	
	
	
	
