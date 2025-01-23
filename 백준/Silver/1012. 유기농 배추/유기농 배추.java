import java.io.*;
import java.util.*;

public class Main {
    static int T, N, M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                map[row][col] = 1;
            }

            int count = 0;
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if(!visited[n][m] && map[n][m] == 1) {
                        dfs(n, m);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int i=0; i<4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            if(nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                    dfs(nextRow, nextCol);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

    }
}
