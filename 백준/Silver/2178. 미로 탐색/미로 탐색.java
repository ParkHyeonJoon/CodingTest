import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=1; i<=N; i++) {
            String info = br.readLine();
            for(int j=1; j<=M; j++) {
                map[i][j] = info.charAt(j-1) - '0';
            }
        }
    }

    static void bfs(int row, int col) {
       Queue<int[]> queue = new LinkedList<>();
       queue.add(new int[]{row, col});

       while(!queue.isEmpty()) {
           int[] now = queue.poll();
           visited[row][col] = true;
           for(int i=0; i<4; i++) {
               int nextRow = now[0] + dRow[i];
               int nextCol = now[1] + dCol[i];
               if(nextRow > 0 && nextRow <= N && nextCol > 0 && nextCol <= M) {
                   if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                        visited[nextRow][nextCol] = true;
                        map[nextRow][nextCol] = map[now[0]][now[1]] + 1;
                        queue.add(new int[]{nextRow, nextCol});
                   }
               }
           }
       }

    }

    public static void main(String[] args) throws IOException {
        input();
        bfs(1, 1);
        System.out.println(map[N][M]);
    }
}
