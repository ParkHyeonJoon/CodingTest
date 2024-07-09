import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String num = n + ""; // String num = Integer.toString(n);
        String[] array = num.split("");
        
        for(String s : array) {
            answer += Integer.parseInt(s);
        }

        return answer;
    }
}