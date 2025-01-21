import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    static void dfs(int count, int num) {
        if(count == N) {
            if(isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for(int i=1; i<=9; i++) {
            if(i%2 == 0) {
                continue;
            }
            if(isPrime(num*10 + i)) {
                dfs(count+1, num*10 + i);
            }
        }
    }
    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num%i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        int[] start = new int[]{2, 3, 5, 7};
        for(int num : start) {
            dfs(1, num);
        }
    }
}
