import java.util.Scanner;

public class Main {

    static int N, S, ans;
    static int[] array;

    public static void main(String[] args) {
        input();

        rec_func(1, 0);
        // S가 0일 경우 공집합 경우는 제외
        if(S == 0) ans--;
        System.out.println(ans);
    }

    static void rec_func(int k, int value) {
        if(k == N + 1) { // 부분수열을 하나 완성시킨 상태
            // value가 S랑 같은지 확인하기
            if(value == S) ans++;
        } else {
            // k번째 원소를 포함시킬지 결정하고 재귀호출 해주기
            // Include
            rec_func(k+1, value+array[k]);
            // Not Include
            rec_func(k+1, value);

        }
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        array = new int[N + 1];
        for(int i=1; i<=N; i++) {
            array[i] = sc.nextInt();
        }
    }
}