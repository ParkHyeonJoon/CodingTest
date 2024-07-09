import java.util.*; 

class Solution {
    public int[] solution(long n) {
        long num = 0;
        
        String result = "";
        
        while(n>0) {
            num = n % 10;
            n = n / 10;
            result += num;
        }
        
        int[] answer = new int[result.length()];
        
        for(int i=0; i<result.length(); i++) {
            answer[i] = Integer.parseInt(result.substring(i, i+1));
        }
    
        return answer;
    }
}