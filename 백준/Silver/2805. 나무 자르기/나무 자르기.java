import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] A;
    static int N, M;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new int[N + 1];
        for(int i=1; i<=N; i++)  {
            A[i] = sc.nextInt();
        }
    }

    static boolean determination(int H) {
        // H 높이로 나무를 잘랐을 때 M만큼 얻을 수 있으면 true, 아니면 false
        long sum = 0;
        for(int i=1; i<=N; i++) {
            if(A[i] > H) {
                sum += A[i] - H;
            }
        }
        return sum >= M;
    }

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;
        // [L...R] 범위 안에 정답이 존재한다.
        // 이분탐색과 determination 문제를 이용해서 answer를 빠르게 구하자!
        while(L <= R) {
            long mid = (L + R) / 2;
            if(determination((int)mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}