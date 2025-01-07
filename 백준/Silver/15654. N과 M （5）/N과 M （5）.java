import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] used;
    static int[] selected;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        used = new boolean[10001];
        selected = new int[M+1];

        String[] inputNum = br.readLine().split(" ");
        for(int i=0; i<inputNum.length; i++) {
            list.add(Integer.parseInt(inputNum[i]));
        }

        // list 숫자를 오름차순으로 정렬
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
            for(int cand : list) {
                if(used[cand]) continue;

                selected[k] = cand;
                used[cand] = true;

                rec(k+1);
                selected[k] = 0;
                used[cand] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec(1);
        System.out.println(sb.toString());
    }
}