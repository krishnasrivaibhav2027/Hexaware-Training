public class NQueensProblem {
    public static void main(String[] args) {
        int n=8;
        boolean[][] board = new boolean[n][n];
        System.out.println(placingQueens(board,0));
    }
    static boolean isSafe(boolean[][] board, int row, int col){
        //checking for the vertical row
        for(int i=0;i<row;i++){ // this means, if already there is a queen present in the vertical rows
            if(board[i][col]){  //then there is no scope for a new queen to be placed in the same vertical row
                return false; // that is why we are returning false
            }
        }   
        //checking for the diagonal left
        int left = Math.min(row,col); // this is how we can find number of columns that are behind the queen that
        for(int i=1;i<=left;i++){  // we are trying to place
            if(board[row-i][col-i]){ // this condition gives an understanding of checking any queen present in previous
                return false; // row and column
            }
        }
        //checking for the diagonal right
        int right = Math.min(row,board.length-col-1); // this is how we can find the number of columns are present
        for(int i=1;i<=right;i++){ //ahead of the queen that we are trying to place
            if(board[row-i][col+i]){  // this condition is for checking the columns that are ahead of the queen
                return false; // returns false if a queen is already present
            }
        }
        return true;
    }
    static int placingQueens(boolean[][] board, int row){
        if(row==board.length){
            displayBoard(board);
            return 1;
        }
        int count=0;
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                count+=placingQueens(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }
    static void displayBoard(boolean[][] board){
        for(boolean[] row:board){
            for(boolean ele:row){
                if(ele){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
