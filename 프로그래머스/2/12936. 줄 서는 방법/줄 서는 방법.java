import java.util.*; 

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        
        long f = 1;
        for(int i=1; i<=n; i++) {
            list.add(i);
            f *= i;
        }
        
        k--;
        int num = 0;
        while(num < n) {
            f = f / (n-num); // (n-1)! = 나눌 수
            answer[num] = list.remove((int)(k/f)); // num번째 자리에 들어갈 수
            num++;
            k = k % f; // 다음 자릿수의 k
        }
        return answer;
    }
}