package tictactoe;

public class Board {

    private char[][] grid = new char[3][3];

    public Board() {

        char num = '1';

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                grid[i][j] = num++;
    }

    public void display() {

        System.out.println();

        for (int i = 0; i < 3; i++) {

            System.out.println(" " + grid[i][0] + " | " + grid[i][1] + " | " + grid[i][2]);

            if (i < 2)
                System.out.println("---|---|---");
        }

        System.out.println();
    }

    public void placeMove(int pos, char symbol) {

        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;

        grid[row][col] = symbol;
    }

    public char getCell(int pos) {

        int row = (pos - 1) / 3;
        int col = (pos - 1) % 3;

        return grid[row][col];
    }

    public boolean isFull() {

        for (int i = 1; i <= 9; i++) {

            char c = getCell(i);

            if (c != 'X' && c != 'O')
                return false;
        }

        return true;
    }
}