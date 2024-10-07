public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if(solveSudoku(board)){
            System.out.println("Yayy! Sudoku Solved");
            displaySudoku(board);
        }
        else{
            System.out.println("Sudoku can't be solved");
        }
    }

    static boolean solveSudoku(int[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyBlock = true;
        // this is how we will find the row,col of empty blocks in sudoku board
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                if(board[i][j]==0){
                    row = i;
                    col = j;
                    emptyBlock = false;
                    break;
                }
            }
            if(!emptyBlock){
                break;
            }
        }
        if(emptyBlock){
            return true;
        }
        // backtracking part
        for(int number = 1; number <= 9; number++){
            if(isSafe(board,row,col,number)){
                board[row][col]=number; // this may not be the right answer
                if(solveSudoku(board)){
                    return true;
                }
                else{
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    static void displaySudoku(int[][] board){
        for(int[] row: board){
            for(int ele:row){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row, int col, int num){
        //checking the rows
        for(int i=0;i<board.length;i++){
            if(board[row][i]==num){
                return false; // we cant place the number if it is already present in that row
            }
        }
        //checking for the cols
        for(int[] nums:board){
            if(nums[col]==num){
                return false;
            }
        }

        int sqrt = (int)(Math.sqrt(board.length));
        int rStart = row - row%sqrt;
        int cStart = col - col%sqrt;

        for(int r = rStart; r < rStart+sqrt; r++){
            for(int c = cStart; c < cStart+sqrt; c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
