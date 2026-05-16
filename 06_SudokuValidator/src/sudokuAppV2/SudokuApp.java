package sudokuAppV2;

import java.util.Scanner;

public class SudokuApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SudokuGame game = new SudokuGame();

        int choice;

        while(true) {

            System.out.println("\n----- Sudoku Game Menu -----");
            System.out.println("1 Start Blank Game");
            System.out.println("2 Start Prefilled Game");
            System.out.println("3 Enter Number");
            System.out.println("4 Display Grid");
            System.out.println("5 Validate Sudoku");
            System.out.println("6 Exit");

            System.out.print("Choice: ");

            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    game.startBlankGame();
                    break;

                case 2:
                    game.startPrefilledGame();
                    break;

                case 3:

                    System.out.print("Row (1-9): ");
                    int r = sc.nextInt()-1;

                    System.out.print("Column (1-9): ");
                    int c = sc.nextInt()-1;

                    System.out.print("Number (1-9): ");
                    int num = sc.nextInt();

                    game.makeMove(r,c,num);
                    break;

                case 4:
                    game.getGrid().displayGrid();
                    break;

                case 5:
                    game.validateSudoku();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}