package com.vaibhav.Game;
import java.util.*;
public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Welcome to TIC TAC TOE");
        char[][] board = new char[3][3];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                board[i][j]=' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);
        while(!gameOver) {
            displaySudoku(board);
            System.out.println("Player " + player + " enter row and column: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = isGameOver(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " is the winner");
                } else {
                    player = (player == 'X' ? 'O' : 'X');
                }
            } else {
                System.out.println("Invalid move");
            }
        }
        displaySudoku(board);
    }
    public static boolean isGameOver(char[][] board, char player){
        return (checkRows(board, player) || checkColumns(board, player) || checkDiagonals(board, player));
    }
    public static boolean checkRows(char[][] board, char player){
        for(int i=0;i<3;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return true;
            }
        }
        return false;
    }
    public static boolean checkColumns(char[][] board, char player){
        for(int i=0;i<3;i++){
            if(board[0][i]==player && board[1][i]==player && board[2][i]==player){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonals(char[][] board, char player){
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }
        return false;
    }
    public static void displaySudoku(char[][] board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }

}
