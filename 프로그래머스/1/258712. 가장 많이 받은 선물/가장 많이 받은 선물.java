import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] graph = new int[friends.length][friends.length]; // 4 x 4
        int[][] result = new int[friends.length][4]; // 준 선물, 받은 선물, 선물 지수, 받을 선물
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i<friends.length; i++) {
            map.put(friends[i], i); // (muzi, 0), (ryan, 1), (frodo, 2), (neo, 3)
        }
        
        for(int i=0; i<gifts.length; i++) {
            String[] name = gifts[i].split(" ");
            int giver = map.get(name[0]);
            int receiver = map.get(name[1]);
            graph[giver][receiver]++;
        }
        
        for(int i=0; i<friends.length; i++) {
            for(int j=0; j<friends.length; j++) {
                result[i][0] = result[i][0] + graph[i][j]; // i가 준 선물의 총 수
                result[i][1] = result[i][1] + graph[j][i]; // i가 받은 선물의 총 수
            }
            result[i][2] = result[i][0] - result[i][1]; // i의 선물 지수
        }
        
        for(int i=0; i<friends.length-1; i++) {
            for(int j=i+1; j<friends.length; j++) {
                if(graph[i][j] == graph[j][i]) { // i와 j가 주고 받은 선물이 같다.
                    if(result[i][2] > result[j][2]) { // 선물지수가 i가 더 높음.
                        result[i][3]++;
                    } else if(result[i][2] < result[j][2]) { // 선물지수가 j가 더 높음
                        result[j][3]++;
                    }
                } else if(graph[i][j] > graph[j][i]) { // i가 j에게 준 선물이 많다.
                    result[i][3]++;
                    
                } else if(graph[i][j] < graph[j][i]) { // j가 i에게 준 선물이 많다.
                    result[j][3]++;
                    
                }
            }
        }
        int max = 0;
        for(int i=0; i<friends.length; i++) {
            if(result[i][3] >= max) {
                max = result[i][3];
            }
        }
        
        return max;
    }
}