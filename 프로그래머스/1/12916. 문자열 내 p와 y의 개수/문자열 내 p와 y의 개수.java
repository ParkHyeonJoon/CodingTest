import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String[] text = new String[s.length()];
        int pNum = 0, yNum = 0;
        
        for(int i=0; i<s.length(); i++) {
            text[i] = s.substring(i, i+1);
        }
        
        for(int i=0; i<text.length; i++) {
            if(text[i].equals("p") || text[i].equals("P")) {
                pNum++;
            } else if(text[i].equals("y") || text[i].equals("Y")) {
                yNum++;
            } else continue;
        }
        
        if(pNum == yNum) answer = true;
        else answer = false;

        return answer;
    }
}