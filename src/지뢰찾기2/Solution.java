package 지뢰찾기2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static int solution(int N, int[][] mine, int[] P) {
        int answer = 0;
        int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
        boolean[][] visited = new boolean[N+1][N+1];
        int[][] mineMap = new int[N+1][N+1];
        for(int[] m : mine) {
            mineMap[m[0]][m[1]] = -1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{P[0], P[1]});
        visited[P[0]][P[1]] = true;

        while(!q.isEmpty()) {
            // 현재 좌표 방문하기
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            answer++;
            
            // count 구하기
            int count = 0;
            for(int i=0; i<8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(0 < nr && nr <= N && 0 < nc && nc <= N) {
                    if(mineMap[nr][nc] == -1) count++;
                }
            }

            // (count가 0인 경우만)next 좌표 예약하기
            if(count == 0) {
                for(int i=0; i<8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(0 < nr && nr <= N && 0 < nc && nc <= N && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }

                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 9;
        int[][] mine = {{1, 2}, {2, 6}, {3, 4}, {3, 8}, {4, 9}, {5, 4}, {5, 8}, {6, 7}, {7, 2}, {9, 1}};
        int[] P = {8, 5};
        System.out.println(solution(N, mine, P));
    }
}
