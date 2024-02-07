package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4396 {
    public static void main(String[] args) throws IOException {
        boolean flag = false; // 지뢰칸 오픈 여부
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] originalBoard = new char[n][n]; // 지뢰 위치는 *, 나머지는 .
        char[][] copyBoard = new char[n][n]; // 사용자가 열어본 곳은 x, 나머지는 .

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8방 탐색을 하기 위한 x축 경우의 수
        int[] dy = {0, 1, -1, 1, -1, 0, 1, -1}; // 8방 탐색을 하기 위한 y축 경우의 수

        // 지뢰 위치 입력
        for(int i=0; i<n; i++) {
            String x = br.readLine();
            for(int j=0; j<n; j++) {
                originalBoard[i][j] = x.charAt(j);
            }
        }

        // 사용자가 열어본 위치 입력
        for(int i=0; i<n; i++) {
            String x = br.readLine();
            for(int j=0; j<n; j++) {
                copyBoard[i][j] = x.charAt(j);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // 주변 지뢰의 개수
                int count = 0;
                // 열린 곳이면서
                if(copyBoard[i][j] == 'x') {
                    // 지뢰라면 모두 열어줘야한다.
                    if(originalBoard[i][j] == '*') {
                        flag = true;
                    }
                    // 지뢰가 아니라면
                    else {
                        // 8방 탐색을 해야한다.
                        for(int k=0; k<dx.length; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];
                            if(x >= 0 && x < n && y >= 0 && y < n && originalBoard[x][y] == '*') {
                                count++;
                            }
                        }
                        copyBoard[i][j] = (char)(count + '0');
                    }
                }
                else {
                    copyBoard[i][j] = '.';
                }
            }
        }
        if(flag) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(originalBoard[i][j] == '*') {
                        copyBoard[i][j] = '*';
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(copyBoard[i][j]);
            }
            System.out.println();
        }
    }
}
