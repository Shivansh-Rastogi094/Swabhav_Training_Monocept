package facadeDesign_TicTacToe;

public class MoveValidator {

	    public static boolean isValidMove(Board board, int move) {

	        if (move < 1 || move > 9)
	            return false;

	        char c = board.getCell(move);

	        return c != 'X' && c != 'O';
	    }
	}
	
	