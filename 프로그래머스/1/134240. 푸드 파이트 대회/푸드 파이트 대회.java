import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
            food[i] = food[i] / 2;
        }
        
        
        int count = 1;
        for(int i=0; i<food.length-1; i++) {
            for(int j=0; j<food[count]; j++) {
                sb.append(count);
            }
            count++;
        }
        
        String answer = sb.toString() + "0" + sb.reverse().toString();
        return answer;
    }
}