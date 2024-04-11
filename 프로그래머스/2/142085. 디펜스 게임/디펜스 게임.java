import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int count = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<enemy.length; i++) {
            n = n - enemy[i];
            pqueue.add(enemy[i]);
            if(n < 0) {
                n = n + pqueue.poll();
                k--;
                if(k < 0) {
                    break;
                }
            }
            count++;
        }
        return count;
    }
}