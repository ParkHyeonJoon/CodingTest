package 지뢰찾기;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public static int solution(int N, int[][] mine, int[] P) {
        int answer = 0;
        int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
        int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
        boolean[][] visited = new boolean[N+1][N+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{P[0], P[1]});

        while(!q.isEmpty()) {


        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] mine = {{1, 2}, {2, 6}, {3, 4}, {3, 8}, {4, 9}, {5, 4}, {5, 8}, {6, 7}, {7, 2}, {9, }};
        int[] P = {8, 5};
        System.out.println(solution(N, mine, P));
    }
}
