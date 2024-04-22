class Solution {
    public int solution(int storey) {
        int answer = 0;
        // storey를 10으로 나눴을 때의 나머지를 remainNum
        // remainNum이 5보다 작거나 같으면 remainNum을 answer에 +, storey = storey-remainNum
        // remainNum이 6보다 크거나 같으면 10 - remainNum을 answer에 +, storey = storey + (10-remainNum)
        // storey >= 10 이면  
        while(storey > 0) {
            int remainNum = storey % 10;
            storey = storey / 10;
            
            if(remainNum == 5) {
                if(storey % 10 >= 5) {
                    answer = answer + (10 - remainNum);
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