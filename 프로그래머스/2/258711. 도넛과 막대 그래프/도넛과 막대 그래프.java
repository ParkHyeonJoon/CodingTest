import java.util.*;

class Solution {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int startPoint;
    private static int max;
    private static int graphCount;
    private static int[] inLine;
    
    private void initGraph(int[][] edges) {
        max = 0;
        for(int[] edge : edges) {
            max = Math.max(max, Math.max(edge[0], edge[1])); 
        }
        visited = new boolean[max + 1];
        inLine = new int[max + 1];
        graph = new ArrayList<>(max + 1);
        
        for(int i=0; i<=max; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            inLine[edges[i][1]]++;
        }
    }
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        initGraph(edges);
        
        startPoint = findStartPoint();
        graphCount = graph.get(startPoint).size();
        answer[0] = startPoint;
        
        cutLineStartPoint(startPoint);
        
        answer[2] = barCount();
        answer[3] = eightCount();
        answer[1] = graphCount - (answer[2] + answer[3]);
        
        return answer;
    }
    
    private int barCount() {
        int count = 0;
        for(int i=1; i<graph.size(); i++) {
            if(i == startPoint) continue;
            if(graph.get(i).isEmpty()) {
                count++;
                visited[i] = true;
            }
        }
        return count;
    }
    
    private int eightCount() {
        int count = 0;
        for(int i=1; i<graph.size(); i++) {
            if(!visited[i]) {
                if(graph.get(i).size() == 2 && inLineCount(i) == 2) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private int findStartPoint() {
        int startPoint = -1;
        for(int i=1; i<graph.size(); i++) {
            if(graph.get(i).size() >= 2 && inLineCount(i) == 0) {
                startPoint = i;
                break;
            }
        }
        visited[startPoint] = true;
        return startPoint;
    }
    
    private int inLineCount(int point) {
        return inLine[point];
    }
    
    private void cutLineStartPoint(int point) {
        for(int p : graph.get(point)) {
            inLine[p]--;
        }
        graph.set(point, new ArrayList<>());
    }
}