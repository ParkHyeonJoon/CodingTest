import java.util.*; 

class Solution {
    public int solution(String s) {
        String[][] chart = { 
            {"0", "zero"},
            {"1", "one"},
            {"2", "two"},
            {"3", "three"},
            {"4", "four"},
            {"5", "five"},
            {"6", "six"},
            {"7", "seven"},
            {"8", "eight"},
            {"9", "nine"}
        };
        for(int i=0; i < 10; i++) {
            s = s.replace(chart[i][1], chart[i][0]);
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
}