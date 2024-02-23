class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        /*
        lottos[]과 win_nums[] 배열을 비교해서 같다면 win_count++;
        
        lottos[]에서 0이 몇개인지 찾아서 그 수만큼 win_count에 더해줌
        
        안 더한 win_count와 더한 win_count를 배열로 출력
        */
        int winCount = 0; int zeroCount = 0;
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                if(lottos[i] == win_nums[j]) {
                    winCount++;
                }
            }
            if(lottos[i] == 0) {
                zeroCount++;
            }
        }
        
        int maxRank = 7 - (winCount + zeroCount);
        int minRank = 7 - winCount;
        if(maxRank > 6) maxRank = 6;
        if(minRank > 6) minRank = 6;
        
        int[] answer = {maxRank, minRank};
        return answer;
    }
}