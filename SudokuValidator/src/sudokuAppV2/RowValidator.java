package sudokuAppV2;

class RowValidator extends SudokuValidator {

    RowValidator(SudokuGrid grid) {
        super(grid);
    }

    boolean validate() throws SudokuException {

        int[][] g = grid.getGrid();

        for(int i=0;i<9;i++) {

            boolean[] seen = new boolean[10];

            for(int j=0;j<9;j++) {

                int num = g[i][j];

                if(num<1 || num>9)
                    throw new SudokuException("Invalid number in row "+(i+1));

                if(seen[num])
                    throw new SudokuException("Duplicate in row "+(i+1));

                seen[num] = true;
            }
        }

        return true;
    }
}