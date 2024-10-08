import java.util.*;

class Solution {
    boolean isInRange(int r, int c, int rowLength, int colLength) {
        return ((r >= 0 && r < rowLength) && (c >= 0 && c < colLength));
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        boolean[][] visited = new boolean[rowLength][colLength];
        
        for(int i=0; i<rowLength; i++) {
            for(int j=0; j<colLength; j++) {
                if((grid[i][j] == '1') && (!visited[i][j])) {
                    bfs(i, j, grid, visited);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public void bfs(int r, int c, char[][] grid, boolean[][] visited) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for(int i=0; i<4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                if(isInRange(nextRow, nextCol, rowLength, colLength)) {
                    if(grid[nextRow][nextCol] == '1' && !(visited[nextRow][nextCol])) {
                        queue.offer(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
    }
}