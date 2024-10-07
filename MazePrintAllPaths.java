import java.util.ArrayList;
import java.util.Arrays;

public class MazePrintAllPaths {
    public static void main(String[] args) {
        boolean[][] matrix = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[matrix.length][matrix[0].length];
        System.out.println(printAllPaths("", matrix, 0, 0));
        printPathMatrices("", matrix, 0, 0, path, 1);
    }

    static ArrayList<String> printAllPaths(String paths, boolean[][] matrix, int row, int col) {
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(paths);
            return list;
        }
        if (!matrix[row][col]) {
            return new ArrayList<>();
        }
        ArrayList<String> list = new ArrayList<>();
        matrix[row][col] = false;
        if (row < matrix.length - 1) {
            list.addAll(printAllPaths(paths + 'D', matrix, row + 1, col));
        }
        if (col < matrix[0].length - 1) {
            list.addAll(printAllPaths(paths + 'R', matrix, row, col + 1));
        }
        if (row > 0) {
            list.addAll(printAllPaths(paths + 'U', matrix, row - 1, col));
        }
        if (col > 0) {
            list.addAll(printAllPaths(paths + 'L', matrix, row, col - 1));
        }

        matrix[row][col] = true;
        return list;
    }

    static void printPathMatrices(String paths, boolean[][] matrix, int row, int col, int[][] path, int step) {
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(paths);
            System.out.println();
            return;
        }
        if (!matrix[row][col]) {
            return;
        }
        matrix[row][col] = false;
        path[row][col] = step;

        if (row < matrix.length - 1) {
            printPathMatrices(paths + 'D', matrix, row + 1, col, path, step + 1);
        }
        if (col < matrix[0].length - 1) {
            printPathMatrices(paths + 'R', matrix, row, col + 1, path, step + 1);
        }
        if (row > 0) {
            printPathMatrices(paths + 'U', matrix, row - 1, col, path, step + 1);
        }
        if (col > 0) {
            printPathMatrices(paths + 'L', matrix, row, col - 1, path, step + 1);
        }

        
        matrix[row][col] = true;
        path[row][col] = 0;
    }

}
