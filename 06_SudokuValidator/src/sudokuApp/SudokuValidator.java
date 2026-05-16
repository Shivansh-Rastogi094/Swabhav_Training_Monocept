package sudokuApp;

abstract class SudokuValidator {

    protected SudokuGrid grid;

    SudokuValidator(SudokuGrid grid) {
        this.grid = grid;
    }

    abstract boolean validate() throws SudokuException;
}