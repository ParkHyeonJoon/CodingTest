class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        for(int i=0; i<rooms.size(); i++) {
            graph.put(i, rooms.get(i));
        }
        boolean[] visited = new boolean[rooms.size()];
        
        dfs(graph, visited, 0);
        
        for(int i=0; i<rooms.size(); i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;
        for(int nextX : graph.get(start)) {
            if(!visited[nextX]) {
                dfs(graph, visited, nextX);
            }
        }
    }
}