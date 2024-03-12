import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long queue1Sum = 0;
        long queue2Sum = 0;
        int count = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i=0; i<queue1.length; i++) {
            queue1Sum += (long)queue1[i];
            q1.add(queue1[i]);
            queue2Sum += (long)queue2[i];
            q2.add(queue2[i]);
        }
        
        while(queue1Sum != queue2Sum) {
            int firstNumber = 0;
            if(count > (queue1.length+queue2.length)*2) return -1;
            if(queue1Sum > queue2Sum) {
                firstNumber = q1.poll();
                
                if(q1.isEmpty()) return -1;
                
                q2.add(firstNumber);
                count++;
                queue1Sum -= (long)firstNumber;
                queue2Sum += (long)firstNumber;
            } else if(queue2Sum > queue1Sum) {
                firstNumber = q2.poll();
                
                if(q2.isEmpty()) return -1;
                
                q1.add(firstNumber);
                count++;
                queue1Sum += (long)firstNumber;
                queue2Sum -= (long)firstNumber;
            }
        }
        
        return count;
    }
}