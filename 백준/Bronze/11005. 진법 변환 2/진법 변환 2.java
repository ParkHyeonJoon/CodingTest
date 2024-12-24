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
        Stack<String> stack = new Stack<>();
        while(N >= B) {
            int remain = N%B; // 나머지, B진법으로 전환한 수에 들어가야 하는 값
            if(remain > 9) {
                stack.push(changeNumToChar(remain));
            } else {
                stack.push(String.valueOf(remain));
            }
            N /= B; // 몫, 다음에 나눌 값
        }
        
        if(N > 9) {
            stack.push(changeNumToChar(N));
        } else {
            stack.push(String.valueOf(N));
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb.toString());
    }

    static String changeNumToChar(int remain) {
        char c = (char) (remain - 10 + 'A');
        return String.valueOf(c);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}