import java.util.*;

class Solution {
    boolean[] visited;
    int count = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        quest(k, dungeons, 0);
        return count;
    }
    
    private void quest(int k, int[][] dungeons, int depth) {
        for(int i=0; i<dungeons.length; i++) {
            if(k < dungeons[i][0] || visited[i]) {
                continue;
            }
            
            visited[i] = true;
            quest(k-dungeons[i][1], dungeons, depth+1);
            visited[i] = false;
          
        }
        
        count = Math.max(count, depth);
    }
}