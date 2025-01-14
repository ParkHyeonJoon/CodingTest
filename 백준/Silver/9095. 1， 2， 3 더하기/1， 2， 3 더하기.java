import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] dp;

    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new int[11];
        arr = new int[T];
        for(int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }

    static void dynamic() {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
    }

    static void pro() {
        for(int i : arr) {
            System.out.println(dp[i]);
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        dynamic();
        pro();
    }
}
