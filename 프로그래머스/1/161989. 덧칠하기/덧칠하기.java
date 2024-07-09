class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n]; // 칠해야 하는 칸을 배열로 표현
        for(int sec : section) {
            wall[sec-1] = -1; // section에 있는, 칠해야 하는 벽을 -1로 채움
        }
        for(int i=0; i<n; i++) {
            if(wall[i] == 0) {
                continue; // 벽을 하나씩 돌면서 0 이면 칠해져있으므로 다시 for문으로 가서 다음 칸
            } else { // 벽이 0이 아니라면 안 칠해져있는 칸이므로 
                answer++; // answer에 1 더해주고
                for(int j=i; j<i+m; j++) { // 그 칸부터 롤러 길이만큼 칸까지
                    wall[j] = 0; // 칸을 0으로 처리
                    if(j == n-1) break;
                }
            }
        }
        return answer;
    }
}