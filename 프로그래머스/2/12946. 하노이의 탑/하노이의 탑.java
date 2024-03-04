import java.util.*;

class Solution {
    private static List<int[]> arr;
    public int[][] solution(int n) {
        arr = new ArrayList<>();
        move(n, 1, 2, 3);
        int[][] answer = new int[arr.size()][];
        for(int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
        
    }
    private static void move(int cnt, int start, int mid, int end) {
        if(cnt == 1) {
            arr.add(new int[]{start, end});
        } else {
            move(cnt-1, start, end, mid);
            arr.add(new int[]{start, end});
            move(cnt-1, mid, start, end);
        }
    }
}