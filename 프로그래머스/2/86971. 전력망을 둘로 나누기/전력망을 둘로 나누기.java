import java.util.*;

class Solution {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        arr = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            arr[from][to] = 0;
            arr[to][from] = 0;

            answer = Math.min(answer, bfs(from, n));
            
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        return answer;
    }

    static int bfs(int from, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(from);

        while (!q.isEmpty()) {
            int temp = q.poll();
            visited[temp] = true;
            for (int i=1; i < n + 1; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    q.add(i);
                    cnt++;
                }
            }
        }

        return Math.abs(cnt - (n - cnt));
    }
}