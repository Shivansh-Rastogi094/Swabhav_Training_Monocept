package sudokuAppV2;

import java.util.Random;

class SudokuGame {

    private SudokuGrid grid;
    private Random rand = new Random();

    SudokuGame() {
        grid = new SudokuGrid();
    }

    SudokuGrid getGrid() {
        return grid;
    }

    void startBlankGame() {
        grid = new SudokuGrid();
        System.out.println("Blank Sudoku started.");
    }

    void startPrefilledGame() {

        grid = new SudokuGrid();

        int filled = 15;

        while(filled>0) {

            int r = rand.nextInt(9);
            int c = rand.nextInt(9);
            int num = rand.nextInt(9)+1;

            if(grid.getNumber(r,c)==0 && isMoveValid(r,c,num)) {

                grid.setNumber(r,c,num);
                grid.setFixed(r,c);
                filled--;
            }
        }

        System.out.println("Prefilled Sudoku generated.");
    }

    boolean isMoveValid(int row,int col,int num) {

        int[][] g = grid.getGrid();

        for(int i=0;i<9;i++)
            if(g[row][i]==num)
                return false;

        for(int i=0;i<9;i++)
            if(g[i][col]==num)
                return false;

        int startRow = row-row%3;
        int startCol = col-col%3;

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(g[startRow+i][startCol+j]==num)
                    return false;

        return true;
    }

    void makeMove(int r,int c,int num) {

        if(grid.isFixed(r,c)) {
            System.out.println("Cannot modify prefilled cell.");
            return;
        }

        if(!isMoveValid(r,c,num)) {
            System.out.println("Invalid move.");
            return;
        }

        grid.setNumber(r,c,num);
        System.out.println("Move placed.");
    }

    void validateSudoku() {

        try {

            RowValidator rv = new RowValidator(grid);
            ColumnValidator cv = new ColumnValidator(grid);
            BoxValidator bv = new BoxValidator(grid);

            if(rv.validate() && cv.validate() && bv.validate())
                System.out.println("Sudoku solved correctly!");

        }

        catch(SudokuException e) {

            System.out.println("Sudoku incorrect.");
            System.out.println(e.getMessage());

        }
    }
}