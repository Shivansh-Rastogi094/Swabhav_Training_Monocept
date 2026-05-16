package facadeDesign_TicTacToe;

import java.util.Random;
public class ComputerPlayer extends Player {
	    private Random rand = new Random();

	    public ComputerPlayer(String name, char symbol) throws Exception {
	        super(name, symbol);
	    }

	    public int generateMove(Board board) {

	        while (true) {

	            int move = rand.nextInt(9) + 1;

	            if (MoveValidator.isValidMove(board, move))
	                return move;
	        }
	    }
	}
	