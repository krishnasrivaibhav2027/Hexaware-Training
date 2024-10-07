public class SudokuSolverChar {
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
        if (solveSudoku(board)) {
            System.out.println("Yay! Sudoku Solved");
            displaySudoku(board);
        } else {
            System.out.println("Sudoku can't be solved");
        }
    }

    static boolean solveSudoku(char[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyBlock = true;
        // this is how we will find the row, col of empty blocks in sudoku board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    row = i;
                    col = j;
                    emptyBlock = false;
                    break;
                }
            }
            if (!emptyBlock) {
                break;
            }
        }
        if (emptyBlock) {
            return true;
        }
        // backtracking part
        for (char number = '1'; number <= '9'; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number; // this may not be the right answer
                if (solveSudoku(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    static void displaySudoku(char[][] board) {
        for (char[] row : board) {
            for (char ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(char[][] board, int row, int col, char num) {
        // checking the rows
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false; // we can't place the number if it is already present in that row
            }
        }
        // checking for the columns
        for (char[] nums : board) {
            if (nums[col] == num) {
                return false;
            }
        }

        int sqrt = (int) (Math.sqrt(board.length));
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
