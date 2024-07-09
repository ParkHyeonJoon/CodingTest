//package Baekjoon;
//
//import java.util.*;
//
//public class _1012 {
//    static int testCount;
//    static int x, y;
//    static int M, N, K;
//    static int[] dx = {-1, 1, 0, 0};
//    static int[] dy = {0, 0, -1, 1};
//    static Queue<int[]> queue = new LinkedList<>();
//    static boolean[][] visited;
//    static int[][] map;
//    static int ret;
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int testCount = sc.nextInt();
//        for(int i=0; i<testCount; i++) {
//            ret = 0;
//            M = sc.nextInt(); // 가로 길이
//            N = sc.nextInt(); // 세로 길이
//            K = sc.nextInt();
//
//            visited = new boolean[N][M]; // 방문 확인 배열
//            map = new int[N][M];
//
//            for(int j=0; j<K; j++) {
//                int x = sc.nextInt();
//                int y = sc.nextInt();
//
//                map[x][y] = 1;
//            }
//
//            for(int x=0; x<N; x++) {
//                for(int y=0; y<M; y++) {
//                    if(map[x][y] == 1 && !visited[x][y]) {
//                        queue.add(new int[]{x, y});
//                        ret++;
//                    }
//
//                    visited[x][y] = true;
//
//                    while(!queue.isEmpty()) {
//                        int[] current = queue.poll();
//                        int curY = current[0];
//                        int curX = current[1];
//
//                        for (int r = 0; r < 4; r++) {
//                            int nx = curX + dx[r];
//                            int ny = curY + dy[r];
//                            if (0 > nx || 0 > ny || nx >= M || ny >= N || map[ny][nx] == 0 || visited[ny][nx]) continue;
//                            else if (map[ny][nx] == 1 && !visited[ny][nx]) {
//                                queue.add(new int[]{ny, nx});
//                                visited[ny][nx] = true;
//                            }
//                        }
//                    }
//
//                }
//            }
//
//        }
//        System.out.println(ret);
//    }
//}
import java.util.*;

public class Main {
    static int testCount;
    static int M, N, K;
    static boolean[][] visited;
    static int[][] map;
    static int count;
    static Queue<int[]> q;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        testCount = sc.nextInt();
        for(int i = 0; i<testCount; i++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new int[M][N];
            visited = new boolean[M][N];
            count = 0;

            for(int j=0; j<K; j++) {
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();
                map[p1][p2] = 1;
            }

            for(int x=0; x<M; x++) {
                for(int y=0; y<N; y++) {
                    if(map[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visited[x][y] = true;
            q.poll();
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
                else {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
