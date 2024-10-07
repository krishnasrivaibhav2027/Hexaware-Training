public class NKnightsProblem {
    public static void main(String[] args) {
        int n = 5;
        //int knights = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(placingKnights(board, 0, 0, n));
    }

    static int placingKnights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            displayBoard(board);
            return 1;
        }

        int count = 0;
        if (row == board.length - 1 && col == board.length) {
            return 0;
        }

        if (col == board.length) { //whenever the col reaches the end of the board, then it must go to the next row
            count += placingKnights(board, row + 1, 0, knights);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true; //placing the knight
            count += placingKnights(board, row, col + 1, knights - 1);
            board[row][col] = false; // reverting back it to the default state, so that we can find other possible ways
        }
        count += placingKnights(board, row, col + 1, knights);

        return count;
    }

    static void displayBoard(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean ele : row) {
                if (ele) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;
        }
        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;
        }
        if (isValid(board, row - 2, col + 1) && board[row - 2][col + 1]) {
            return false;
        }
        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;
        }
        return true;
    }

    static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }
}
