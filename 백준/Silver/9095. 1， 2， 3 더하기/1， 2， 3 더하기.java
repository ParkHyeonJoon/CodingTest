import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] Dy;

    static void preprocess() {
        Dy = new int[15];
        
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;
        
        for(int i=4; i<=11; i++) {
            Dy[i] = Dy[i-1] + Dy[i-2] + Dy[i-3];
        }
    }

    static void pro() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1; i<=T; i++) {
            int N = sc.nextInt();
            sb.append(Dy[N]).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        preprocess();
        pro();
    }
}