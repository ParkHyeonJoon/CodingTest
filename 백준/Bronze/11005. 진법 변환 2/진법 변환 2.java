import java.util.*;
public class Main {

    static int N;
    static int B;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        B = sc.nextInt();
    }

    static void pro() {
        StringBuilder sb = new StringBuilder();
        
        while (N > 0) {
            int remain = N % B; // 나머지 계산
            if (remain > 9) {
                sb.append((char) (remain - 10 + 'A')); // 알파벳으로 변환
            } else {
                sb.append(remain); // 숫자로 변환
            }
            N /= B; // 몫 계산
        }

        // 최종 결과 뒤집기
        System.out.print(sb.reverse().toString());
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
