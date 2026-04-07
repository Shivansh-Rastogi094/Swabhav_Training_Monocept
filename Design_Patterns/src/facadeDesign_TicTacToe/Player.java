package facadeDesign_TicTacToe;

public class Player {

	    private String name;
	    private char symbol;

	    public Player(String name, char symbol) throws Exception {

	        if (name == null || name.isEmpty())
	            throw new Exception("Name cannot be empty");

	        this.name = name;
	        this.symbol = symbol;
	    }

	    public String getName() {
	        return name;
	    }

	    public char getSymbol() {
	        return symbol;
	    }
	}
	