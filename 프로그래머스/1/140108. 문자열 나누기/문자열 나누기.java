class Solution {
    public int solution(String s) {
        int answer = 1;
        int xCount = 1; int diffCount = 0;
        char x = s.charAt(0);
        
        for(int i=1; i<s.length(); i++) {
            if(xCount == diffCount) {
                answer++;
                x = s.charAt(i);
                xCount = 0; diffCount = 0;
            }
            
            if(x == s.charAt(i)) {
                xCount++;
            } else {
                diffCount++;
            }
            
            
        }
        
        return answer;
    }
}