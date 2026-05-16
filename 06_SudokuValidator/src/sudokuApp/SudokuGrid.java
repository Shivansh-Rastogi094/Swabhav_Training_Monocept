package sudokuApp;

class SudokuGrid {

    private int[][] grid;

    SudokuGrid(int[][] grid) throws SudokuException {

        if (grid == null || grid.length != 9 || grid[0].length != 9) {
            throw new SudokuException("Grid must be 9x9");
        }

        this.grid = grid;
    }

    int[][] getGrid() {
        return grid;
    }

    void printGrid() {

        System.out.println("\nSudoku Grid:\n");

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }

            System.out.println();
        }
    }
}