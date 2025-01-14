import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] t;
    static int[] p;
    static int[] dp;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        t = new int[N];
        p = new int[N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1];
    }
    static void pro() {
        for(int i=0; i<N; i++) {
            if(i+t[i] <= N) {
                dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
