package sudokuAppV2;

class ColumnValidator extends SudokuValidator {

    ColumnValidator(SudokuGrid grid) {
        super(grid);
    }

    boolean validate() throws SudokuException {

        int[][] g = grid.getGrid();

        for(int j=0;j<9;j++) {

            boolean[] seen = new boolean[10];

            for(int i=0;i<9;i++) {

                int num = g[i][j];

                if(seen[num])
                    throw new SudokuException("Duplicate in column "+(j+1));

                seen[num] = true;
            }
        }

        return true;
    }
}