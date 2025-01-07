import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        selected = new int[M+1];
        selected[0] = 1;
    }
    static void rec(int k) {
        // Base case
        if(k == M+1) {
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(" ");
            sb.append('\n');
        }
        // Recursion
        else {
            for(int cand=selected[k-1]; cand<=N; cand++) {
                selected[k] = cand;
                rec(k+1);
                selected[k] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec(1);
        System.out.println(sb.toString());
    }
}