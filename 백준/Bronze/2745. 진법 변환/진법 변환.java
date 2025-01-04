import java.io.*;
import java.util.*;

public class Main {
    static String N;
    static int B;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = input[0];
        B = Integer.parseInt(input[1]);
    }
    static void pro() {
        int sum = 0;
        int length = N.length();

        for(int i=0; i<length; i++) {
            char ch = N.charAt(i);
            int num;

            if(ch >= 'A' && ch <= 'Z') {
                num = ch - 55;
            } else {
                num = ch - '0';
            }

            sum = (int) (sum + num * Math.pow(B, length - i - 1));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}