package sudokuAppV2;

class BoxValidator extends SudokuValidator {

    BoxValidator(SudokuGrid grid) {
        super(grid);
    }

    boolean validate() throws SudokuException {

        int[][] g = grid.getGrid();

        for(int row=0;row<9;row+=3) {

            for(int col=0;col<9;col+=3) {

                boolean[] seen = new boolean[10];

                for(int i=0;i<3;i++) {

                    for(int j=0;j<3;j++) {

                        int num = g[row+i][col+j];

                        if(seen[num])
                            throw new SudokuException("Duplicate in 3x3 box");

                        seen[num] = true;
                    }
                }
            }
        }

        return true;
    }
}