import java.util.Scanner;

public class Main {

    static int N, M;
    static int[] selected, used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }

    // Recurrence Funtion(재귀함수)
    // 만약 M개를 전부 고름 -> 조건에 맞는 탐색을 한 가지 성공한 것!
    // 아직 M개를 고르지 않음 -> k 번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도한다.
    static void rec_func(int k) {
        if(k == M + 1) { // 다 골랐다!
            // selected[1..M] 배열이 새롭게 탐색된 결과
            for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {
            int start = selected[k-1];
            if(start == 0) start = 1;
            for(int cand=start; cand <=N; cand++) {
                selected[k] = cand;

                // k+1번 ~ M번 을 모두 탐색하는 일을 해야 하는 상황
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[M + 1];
    }
}