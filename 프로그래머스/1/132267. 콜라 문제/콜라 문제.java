class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int cola = (n / a) * b; // 얻은 병 수
            answer = answer + cola;
            int remain = n % a;
            n = cola + remain;
        }
        return answer;
    }
}