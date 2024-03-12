import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    List<Group> groups = new ArrayList<>();
    int width, height;
    boolean[][] visited;
    int[][] land;
    
    public int solution(int[][] land) {
        int maxNum = 0;
        this.land = land;
        initGroups(land);
        int[] answer = new int[land[0].length];
    
        for(int i=0; i<groups.size(); i++) {
            for(int offset : groups.get(i).possibleY){
                answer[offset] += groups.get(i).count;
                maxNum = Math.max(maxNum, answer[offset]);
            }
        }
        
        return maxNum;
    }
    
    private void initGroups(int[][] land) {
        visited = new boolean[land.length][land[0].length];
        height = land.length;
        width = land[0].length;
        
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(visited[i][j] || land[i][j] == 0) continue;
                groups.add(bfs(i,j));
            }
        }
    }
    
    private Group bfs(int nx, int ny) {
        Queue<List<Integer>> q = new LinkedList<>();
        Set<Integer> possibleY = new HashSet<>();
        
        int count = 1;
        q.add(List.of(nx, ny));
        visited[nx][ny] = true;
        possibleY.add(ny);
        
        while(!q.isEmpty()) {
            List<Integer> temp = q.poll();
            int x = temp.get(0);
            int y = temp.get(1);
            
            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= height || nextY >= width
                  || land[nextX][nextY] == 0 || visited[nextX][nextY]) continue;
                
                visited[nextX][nextY] = true;
                q.add(List.of(nextX, nextY));
                count++;
                possibleY.add(nextY);
            }
        }
        return new Group(possibleY, count);
    }
    
    public class Group {
        Set<Integer> possibleY;
        int count;
        public Group(Set<Integer> possibleY, int count) {
            this.possibleY = possibleY;
            this.count = count;
        }
    }
}