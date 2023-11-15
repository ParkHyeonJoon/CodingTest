package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2758 {

    static int[][] bingo = new int[5][5]; // 빙고판 배열 선언
    static int count; // 빙고 수
    static int turn = 1; // 몇 번 불렀는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken()); // 입력 받은 값 모두 넣어줌
            }
        }

        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 5개씩 끊어서 부르기 때문에

            for(int j=0; j<5; j++) {
                int num = Integer.parseInt(st.nextToken());

                for(int k=0; k<5; k++) {
                    for(int l=0; l<5; l++) {
                        if(bingo[k][l] == num) {
                            bingo[k][l] = 0;
                        }
                    }
                }

                row();
                col();
                lrCheck();
                rlCheck();

                if(count >= 3) {
                    System.out.println(turn);
                    System.exit(0);
                }
                count = 0;
                turn++;
            }
        }
    }

    public static void row() { // 행 체크  ----->
        for(int i=0; i<5; i++) {
            int zeroCount = 0;
            for(int j=0; j<5; j++) {
                if(bingo[i][j] == 0) // y축 고정 시켜놓고
                    zeroCount++;
                if(zeroCount == 5) {
                    count++;
                }
            }
        }
    }

    public static void col() { // 열 체크
        for(int i=0; i<5; i++) {
            int zeroCount = 0;
            for(int j=0; j<5; j++) {
                if(bingo[j][i] == 0) // x축 고정 시켜놓고
                    zeroCount++;
                if(zeroCount == 5)
                    count++;
            }
        }
    }

    public static void rlCheck() { // 오른쪽 위에서 왼쪽 밑으로 향하는 대각선 체크
        int zeroCount = 0;
        for(int i=0; i<5; i++) {
            if (bingo[i][4 - i] == 0) {
                zeroCount++;
            }
        }
        if(zeroCount == 5) {
            count++;
        }
    }

    public static void lrCheck() { // 왼쪽 위에서 오른쪽 밑으로 향하는 대각선 체크
        int zeroCount = 0;
        for(int i=0; i<5; i++) {
            if (bingo[i][i] == 0)
                zeroCount++;
        }
        if(zeroCount == 5) {
            count++;
        }
    }
}
