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
            String num = String.valueOf(i);
            int length = num.length();
            for(int j=0; j<length; j++) {
                sum += num.charAt(j) - '0';
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