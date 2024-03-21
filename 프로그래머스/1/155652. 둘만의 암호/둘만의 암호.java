import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
    
        for(int i=0; i<s.length(); i++) {
            int count = 1;
            char c = s.charAt(i);
            
            while(count <= index) {
                ++c;
                if(c > 'z') c -= 26;
                
                if(skip.contains(String.valueOf(c))) {
                    continue;
                } else {
                    count++;
                }
            }
            
            sb.append(c);
            
        }
        return sb.toString();
    }
}