import java.util.*;

class Solution {

    public int[] solution(String s) {
        int count = 0;
        int removedZeros = 0;
        
        while(!s.equals("1")) {
            int length = s.length();
            StringBuilder sb = new StringBuilder();
            
            for(char c : s.toCharArray()) {
                if(c == '1') {
                    sb.append(c);
                } else {
                    removedZeros++;
                }
            }
            s = Integer.toBinaryString(sb.length());
            count++;
        }
        int[] answer = new int[]{count, removedZeros};
        return answer;
    }
}