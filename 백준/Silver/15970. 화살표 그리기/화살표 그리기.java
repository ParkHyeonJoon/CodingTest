import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int N;
    static ArrayList<Integer> a[];

    static int toLeft(int color, int idx) {
        if(idx == 0) return Integer.MAX_VALUE;
        else return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if(idx + 1 == a[color].size()) return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = new ArrayList[N + 1];

        for(int i=1; i<=N; i++) {
            a[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=N; i++) {
            int color, coord;
            coord = sc.nextInt();
            color = sc.nextInt();

            a[color].add(coord);
        }
    }

    static void pro() {
        for(int color=1; color<=N; color++) {
            Collections.sort(a[color]);
        }
        int ans = 0;
        for(int i=1; i<=N; i++) {
            for(int color=0; color < a[i].size(); color++) {
                int left = toLeft(i, color);
                int right = toRight(i, color);
                ans += Math.min(left, right);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}