import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }
    static void pro() {
        for(int i=1; i<N; i++) {
            int sum = i;
            int num = i;
            while(num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if(sum == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}