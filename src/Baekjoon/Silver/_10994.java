package Baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10994 {
    static char star[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sn = br.readLine();
        int n = Integer.parseInt(sn);
        n = 4 * n - 3;
        star = new char[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                star[i][j] = ' ';
            }
        }

        _10994(0, n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }
    }

    public static void _10994(int s, int len) {
        if(len <= s) return;

        for(int i = s; i < len; i++) {
            star[s][i] = '*';
            star[len - 1][i] = '*';
            star[i][s] = '*';
            star[i][len - 1] = '*';
        }

        _10994(s + 2, len - 2);
    }
}
