package sudokuApp;import java.util.Scanner;

public class SudokuApp {

    static Scanner sc = new Scanner(System.in);
    static SudokuGrid sudokuGrid = null;

    public static void main(String[] args) {

        int choice;

        while (true) {

            System.out.println("\n------ Sudoku Validator Menu ------");
            System.out.println("1. Enter Sudoku Grid");
            System.out.println("2. Display Grid");
            System.out.println("3. Validate Sudoku");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {

                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        sudokuGrid = inputGrid();
                        break;

                    case 2:
                        if (sudokuGrid == null)
                            System.out.println("Grid not entered yet.");
                        else
                            sudokuGrid.printGrid();
                        break;

                    case 3:
                        validateSudoku();
                        break;

                    case 4:
                        System.out.println("Exiting program...");
                        return;

                    default:
                        System.out.println("Invalid menu option.");

                }

            } catch (Exception e) {

                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();

            }
        }
    }

    static SudokuGrid inputGrid() {

        int[][] grid = new int[9][9];

        System.out.println("\nEnter Sudoku rows (9 digits each):");

        try {

            for (int i = 0; i < 9; i++) {

                while (true) {

                    System.out.print("Row " + (i + 1) + ": ");
                    String row = sc.nextLine();

                    if (row.length() != 9) {
                        System.out.println("Row must contain exactly 9 digits.");
                        continue;
                    }

                    boolean valid = true;

                    for (int j = 0; j < 9; j++) {

                        if (!Character.isDigit(row.charAt(j))) {
                            valid = false;
                            break;
                        }

                        int num = row.charAt(j) - '0';

                        if (num < 1 || num > 9) {
                            valid = false;
                            break;
                        }

                        grid[i][j] = num;
                    }

                    if (!valid) {
                        System.out.println("Invalid row. Only digits 1-9 allowed.");
                        continue;
                    }

                    break;
                }
            }

            return new SudokuGrid(grid);

        } catch (SudokuException e) {

            System.out.println(e.getMessage());
            return null;

        }
    }

    static void validateSudoku() {

        if (sudokuGrid == null) {
            System.out.println("Please enter the Sudoku grid first.");
            return;
        }

        try {

            RowValidator rowValidator = new RowValidator(sudokuGrid);
            ColumnValidator columnValidator = new ColumnValidator(sudokuGrid);
            BoxValidator boxValidator = new BoxValidator(sudokuGrid);

            if (rowValidator.validate() &&
                columnValidator.validate() &&
                boxValidator.validate()) {

                System.out.println("\nSudoku is VALID");
            }

        } catch (SudokuException e) {

            System.out.println("\nSudoku is INVALID");
            System.out.println("Reason: " + e.getMessage());

        }
    }
}