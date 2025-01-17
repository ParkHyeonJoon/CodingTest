import java.io.*;
import java.util.*;

public class Main {
    static int N, min, t;
    static int[][] board;
    static boolean[] visited;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N+1];
        min = Integer.MAX_VALUE;
        t = 0;
        for(t=1; t<N; t++) {
            recursion(1, 0);
        }
    }

    static void recursion(int index, int count) {
        // Base case
        if(count == t) { // 1명 이상이면 됨
            divideTeam();
            return;
        }
        // 아직 한 팀에 한 명도 분배되지 않았다면
        for(int i=index; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                recursion(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    static void divideTeam() {
        List<Integer> startTeamList = new ArrayList<>();
        List<Integer> linkTeamList = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(visited[i]) {
                startTeamList.add(i);
            } else {
                linkTeamList.add(i);
            }
        }

        int startSum = calculateScore(startTeamList);
        int linkSum = calculateScore(linkTeamList);

        min = Math.min(min, Math.abs(startSum-linkSum));
    }

    static int calculateScore(List<Integer> team) {
        int sum = 0;
        for(int i : team) {
            for(int j : team) {
                if(i != j) {
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(min);
    }
}
