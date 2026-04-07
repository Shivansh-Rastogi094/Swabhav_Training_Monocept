package facadeDesign_TicTacToe;

import java.util.Scanner;
public class GameManager {

	    private Board board;
	    private Player player1;
	    private Player player2;
	    private boolean vsComputer;
	    private Scanner sc = new Scanner(System.in);

	    public GameManager(String p1, String p2, boolean vsComputer) throws Exception {

	        board = new Board();
	        player1 = new Player(p1, 'X');

	        if (vsComputer)
	            player2 = new ComputerPlayer(p2, 'O');
	        else
	            player2 = new Player(p2, 'O');

	        this.vsComputer = vsComputer;
	    }

	    public void startGame() {

	        Player current = player1;

	        while (true) {

	            board.display();

	            int move;

	            if (vsComputer && current instanceof ComputerPlayer) {

	                move = ((ComputerPlayer) current).generateMove(board);
	                System.out.println("Computer chose: " + move);

	            } else {

	                System.out.println(current.getName() + "'s turn (" + current.getSymbol() + ")");
	                move = sc.nextInt();
	            }

	            if (!MoveValidator.isValidMove(board, move)) {

	                System.out.println("Invalid move!");
	                continue;
	            }

	            board.placeMove(move, current.getSymbol());

	            if (WinChecker.checkWin(board, current.getSymbol())) {

	                board.display();
	                System.out.println(current.getName() + " wins!");
	                break;
	            }

	            if (board.isFull()) {

	                board.display();
	                System.out.println("Game Draw!");
	                break;
	            }

	            current = (current == player1) ? player2 : player1;
	        }
	    }
	}