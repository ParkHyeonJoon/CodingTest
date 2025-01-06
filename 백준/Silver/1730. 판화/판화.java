import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String commands;
    static char[][] board;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        commands = br.readLine();
        board = new char[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                board[i][j] = 46;
            }
        }
    }
    static void pro() {
        int length = commands.length();
        int row = 0, col = 0;
        for(int i=0; i<length; i++) {
            char command = commands.charAt(i);
            int nextRow = row, nextCol = col;

            switch (command) {
                case 'D' :
                    nextRow++;
                    break;

                case 'R' :
                    nextCol++;
                    break;

                case 'L' :
                    nextCol--;
                    break;

                case 'U' :
                    nextRow--;
                    break;
            }

            if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                continue;
            }

            if(command == 'D') {
                upAndDown(board, row, col);
                upAndDown(board, nextRow, nextCol);
            } else if(command == 'U') {
                upAndDown(board, row, col);
                upAndDown(board, nextRow, nextCol);
            } else {
                rightAndLeft(board, row, col);
                rightAndLeft(board, nextRow, nextCol);
            }

            row = nextRow;
            col = nextCol;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static void upAndDown(char[][] board, int row, int col) {
        if(board[row][col] == 45) {
            board[row][col] = 43;
        } else if(board[row][col] == 43) {
            board[row][col] = 43;
        } else {
            board[row][col] = 124;
        }
    }

    static void rightAndLeft(char[][] board, int row, int col) {
        if(board[row][col] == 43) {
            board[row][col] = 43;
        } else if(board[row][col] == 124) {
            board[row][col] = 43;
        } else {
            board[row][col] = 45;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}