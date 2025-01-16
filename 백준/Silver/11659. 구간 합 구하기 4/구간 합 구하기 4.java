import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A, S, ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N+1];
        S = new int[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = A[i] + S[i-1];
        }

        ans = new int[M];
        for(int n=0; n<M; n++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            ans[n] = S[j] - S[i-1];
        }
    }
    static void pro() {
        for(int i=0; i<M; i++) {
            System.out.println(ans[i]);
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
