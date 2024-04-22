class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {
            int remainNum = storey % 10;
            storey = storey / 10;
            
            if(remainNum == 5) {
                if(storey % 10 >= 5) {
                    answer = answer + remainNum;
                    storey++;
                } else {
                    answer = answer + remainNum;
                }
            } else if(remainNum >= 6) {
                answer = answer + (10-remainNum);
                storey++;
            } else {
                answer = answer + remainNum;
            }
        }
        
        return answer;
    }   
}