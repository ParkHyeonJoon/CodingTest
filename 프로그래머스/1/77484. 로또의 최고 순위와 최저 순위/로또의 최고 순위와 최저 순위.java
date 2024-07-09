class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int winCount = 0; int zeroCount = 0;
        for(int i=0; i<lottos.length; i++) {
            for(int j=0; j<win_nums.length; j++) {
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