import java.util.*;

class Solution {
    Queue<int[]> q;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int answer = -1;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(0, 0, maps);
    }
    
    private int bfs(int x, int y, int[][] maps) {
        q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            int count = q.peek()[2];
            
            q.poll();
            
            if(x == maps.length-1 && y == maps[0].length-1) {
                answer = count;
                break;
            }
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length || maps[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                } else {
                    q.add(new int[]{nx, ny, count+1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return answer;
    }
}