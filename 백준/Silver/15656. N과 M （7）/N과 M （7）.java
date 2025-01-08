import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] selected;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        selected = new int[M+1];
        String[] inputNum = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(inputNum[i]));
        }
        list.sort(Integer::compare);
    }
    static void rec(int k) {
        // Base case
        if(k == M+1) {
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(" ");
            sb.append('\n');
        }
        // Recursion
        else {
            for(int cand=0; cand<N; cand++) {
                selected[k] = list.get(cand);
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