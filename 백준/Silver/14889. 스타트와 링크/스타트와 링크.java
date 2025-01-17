import java.io.*;
import java.util.*;

public class Main {
    static int N, min;
    static int[][] board;
    static boolean[] visited;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        visited = new boolean[N];
    }

    static void pro(int index, int count) {
        // Base Case
        if(count == N/2) {
            divideTeam();
            return;
        }
        for(int i=index; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                pro(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    static void divideTeam() {
        int startSum = 0, linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startSum += board[i][j] + board[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkSum += board[i][j] + board[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(startSum - linkSum));
    }
    
    public static void main(String[] args) throws IOException {
        input();
        pro(0, 0);
        System.out.println(min);
    }
}
