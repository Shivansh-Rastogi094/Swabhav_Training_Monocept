package sudokuAppV2;

class SudokuGrid {

    private int[][] grid;
    private boolean[][] fixed;

    SudokuGrid() {
        grid = new int[9][9];
        fixed = new boolean[9][9];
    }

    int[][] getGrid() {
        return grid;
    }

    boolean isFixed(int r, int c) {
        return fixed[r][c];
    }

    void setFixed(int r, int c) {
        fixed[r][c] = true;
    }

    void setNumber(int r, int c, int num) {
        grid[r][c] = num;
    }

    int getNumber(int r, int c) {
        return grid[r][c];
    }

    boolean isFull() {

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(grid[i][j]==0)
                    return false;

        return true;
    }

    void displayGrid() {

        System.out.println();

        for(int i=0;i<9;i++) {

            if(i%3==0)
                System.out.println("-------------------------");

            for(int j=0;j<9;j++) {

                if(j%3==0) System.out.print("| ");

                if(grid[i][j]==0)
                    System.out.print(". ");
                else
                    System.out.print(grid[i][j]+" ");
            }

            System.out.println("|");
        }

        System.out.println("-------------------------");
    }
}