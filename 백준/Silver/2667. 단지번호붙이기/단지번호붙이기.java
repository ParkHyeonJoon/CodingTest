import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static boolean[][] visited;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            String st = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = st.charAt(j) - '0';
            }
        }
    }

    static int dfs(int row, int col) {
        visited[row][col] = true;
        int count = 1;

        for(int i=0; i<4; i++) {
            int nextRow = row + dRow[i];
            int nextCol = col + dCol[i];
            if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N) {
                if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                       count = count + dfs(nextRow, nextCol);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    list.add(dfs(i, j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int ans : list) {
            System.out.println(ans);
        }

    }
}
