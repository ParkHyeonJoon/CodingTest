import java.util.*; 

class Solution {
    int dx[] = {0, -1, 0, 1};
    int dy[] = {1, 0, -1, 0};
    public int solution(String dirs) {
        int answer = 0;
        int[][] map = new int[11][11];
        boolean[][][] visit = new boolean[11][11][4];
        int sx = 5; int sy = 5;
        for(int i=0; i<dirs.length(); i++) {
            char c = dirs.charAt(i);
            int d = 0;
            if(c == 'U') {
                d = 0;
            }
            if(c == 'L') {
                d = 1;
            }
            if(c == 'D') {
                d = 2;
            }
            if(c == 'R') {
                d = 3;
            }
            int nx = sx + dx[d];
            int ny = sy + dy[d];
            if(nx < 0 || ny < 0 || nx >= 11 || ny >= 11) {
                continue;
            }
            if(!visit[nx][ny][d]) {
                visit[nx][ny][d] = true;
                if(d%2 == 0) {
                    d = 2-d;
                } else {
                    d = 4-d;
                }
                visit[sx][sy][d] = true;
                answer++;
            }
            sx = nx; sy = ny;
        }
        return answer;
    }    
} 