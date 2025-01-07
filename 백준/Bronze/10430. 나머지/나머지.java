import java.io.*;
import java.util.*;

public class Main {

    static int A, B, C;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);
    }
    static void pro() {
        int ans1 = (A+B)%C;
        int ans2 = ((A%C) + (B%C)) %C;
        int ans3 = (A*B)%C;
        int ans4 = ((A%C) * (B%C)) %C;
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}