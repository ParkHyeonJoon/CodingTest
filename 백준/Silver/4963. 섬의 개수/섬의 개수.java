import java.io.*;
import java.util.*;

public class Main {
    static int W, H;
    static boolean[][] visited;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dCol = {0, 0, -1, 1, -1, 1, -1, 1};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) break;

            visited = new boolean[H][W];
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int row, int col) {
        visited[row][col] = true;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                int nextRow = row + dRow[i];
                int nextCol = col + dCol[i];
                if(nextRow >= 0 && nextRow < H && nextCol >= 0 && nextCol < W) {
                    if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        dfs(nextRow, nextCol);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
