// 문제 요약
// 각 명함의 가로, 세로 사이즈를 입력 받음
// 입력 받은 모든 명함을 수납할 수 있는 가장 작은 지갑의 사이즈를 구함
// 단, 명함을 가로로 눕혀서 수납할 수도 있음

// 풀이 과정
// 모든 명함을 긴부분으로 눕힌다고 생각
// 두 변 중에서 긴 부분을 가로에, 짧은 부분을 세로에 대입
// Max(가로), Max(세로)를 곱하여 사이즈 구함

class Solution {
    public int solution(int[][] sizes) {
        int length_max = 0, height_max = 0;
        for (int[] card : sizes) {
            int length = Math.max(card[0], card[1]);
            int height = Math.min(card[0], card[1]);
            
            if(length > length_max) {
                length_max = length;
            }
            
            if(height > height_max) {
                height_max = height;
            }
        }
        int answer = length_max * height_max;
        return answer;
    }
}