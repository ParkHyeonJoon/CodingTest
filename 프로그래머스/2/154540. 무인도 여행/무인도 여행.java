import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    List<Integer> list = new ArrayList<>();
    boolean[][] visited;
    
    public int[] solution(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        
        for(int i=0; i<map.length; i++) {
            map[i] = maps[i].split("");
        }

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
                if(!visited[i][j] && !map[i][j].equals("X")) {
                    int landDepth = bfs(i, j, map, visited);
                    if(landDepth > 0) {
                        list.add(landDepth);
                    }
                }
            }
        }
        if(list.isEmpty()) {
            return new int[]{-1};
        }
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    
    public int bfs(int row, int col, String[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int depth = Integer.parseInt(map[row][col]);
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            
            for(int i=0; i<4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i];
                
                if(nextRow >= 0 && nextRow < map.length && nextCol >= 0 && nextCol < map[0].length) {
                    if(!visited[nextRow][nextCol] && !map[nextRow][nextCol].equals("X")) {
                        queue.add(new int[]{nextRow, nextCol});
                        visited[nextRow][nextCol] = true;
                        depth = depth + Integer.parseInt(map[nextRow][nextCol]);
                    }
                }
            }
        }
        
        return depth;
    }
}