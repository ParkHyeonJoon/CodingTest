class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num; // int로 하면 626331했을 때 오버플로우 발생
        while(n != 1) {
            answer++;
            if(answer > 500) {
                return -1;
            }
            if(n % 2 == 0) n /= 2;
            else if(n % 2 != 0) n = n * 3 + 1;
        
        }
        return answer;
    }
}