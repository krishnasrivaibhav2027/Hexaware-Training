public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'3', '.', '6', '5', '.', '8', '4', '.', '.'},
                {'5', '2', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '8', '7', '.', '.', '.', '.', '3', '1'},
                {'.', '.', '3', '.', '1', '.', '.', '8', '.'},
                {'9', '.', '.', '8', '6', '3', '.', '.', '5'},
                {'.', '5', '.', '.', '9', '.', '6', '.', '.'},
                {'1', '3', '.', '.', '.', '.', '2', '5', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '7', '4'},
                {'.', '.', '5', '2', '.', '6', '3', '.', '.'}
        };
        if(isValid(board)){
            System.out.println("The given sudoku is a valid one");
        }
        else{
            System.out.println("The given sudoku is not a valid one");
        }
    }

    static boolean isValid(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    char num = board[i][j];
                    // Temporarily empty the cell for validation
                    board[i][j] = '.';
                    boolean check = isSafe(board, i, j, num);
                    // Restore the cell value
                    board[i][j] = num;

                    if (!check) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isSafe(char[][] board, int row, int col, char num) {
        // checking the row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // checking the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // checking the 3x3 subgrid
        int sqrt = (int) Math.sqrt(board.length);
        int rStart = row - row % sqrt;
        int cStart = col - col % sqrt;

        for (int r = rStart; r < rStart + sqrt; r++) {
            for (int c = cStart; c < cStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
