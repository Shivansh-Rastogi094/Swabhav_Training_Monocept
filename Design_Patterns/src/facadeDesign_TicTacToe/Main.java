package facadeDesign_TicTacToe;

import java.util.Scanner;
public class Main {
	
	    public static void main(String[] args) {

	        TicTacToeFacade facade = new TicTacToeFacade();
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            facade.showMenu();
	            int choice = sc.nextInt();
	            sc.nextLine();

	            boolean continueGame = facade.handleMenuChoice(choice);
	            if (!continueGame) break;
	        }

	        facade.closeResources();
	        sc.close();
	    }
	}
	