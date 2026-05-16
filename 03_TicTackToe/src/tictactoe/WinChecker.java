package tictactoe;

public class WinChecker {

    public static boolean checkWin(Board board, char symbol) {

        char[] b = new char[9];

        for (int i = 1; i <= 9; i++)
            b[i - 1] = board.getCell(i);

        int[][] winPatterns = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] p : winPatterns) {

            if (b[p[0]] == symbol && b[p[1]] == symbol && b[p[2]] == symbol)
                return true;
        }

        return false;
    }
}