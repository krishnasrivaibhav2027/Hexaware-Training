import java.util.ArrayList;

public class MazeProblemPrintPaths {
    public static void main(String[] args) {
        printPaths("",3,3);
        System.out.println(printDiagonalPaths("",3,3));
        boolean[][] matrix = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        printPathsWithObstacle("",matrix,0,0);
    }
    static void printPaths(String paths, int row, int col){
        if(row==1 && col==1){
            System.out.println(paths);
            return;
        }
        if(row>1){
            printPaths(paths+'D',row-1,col);
        }
        if(col>1){
            printPaths(paths+'R',row,col-1);
        }
    }
    static ArrayList<String> printDiagonalPaths(String paths, int row, int col){
        if(row==1 && col==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(paths);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if(row>1 && col>1){
            list.addAll(printDiagonalPaths(paths+'D',row-1,col-1));
        }
        if(row>1){
            list.addAll(printDiagonalPaths(paths+'V',row-1,col));
        }
        if(col>1){
            list.addAll(printDiagonalPaths(paths+'H',row,col-1));
        }
        return list;
    }
    static void printPathsWithObstacle(String paths, boolean[][] matrix, int row, int col){
        if(row== matrix.length-1 && col== matrix[0].length-1){
            System.out.println(paths);
            return;
        }
        if(!matrix[row][col]){
            return ;
        }
        if(row < matrix.length-1){
            printPathsWithObstacle(paths+'D',matrix ,row+1,col);
        }
        if(col < matrix[0].length-1){
            printPathsWithObstacle(paths+'R',matrix,row,col+1);
        }

    }
}
