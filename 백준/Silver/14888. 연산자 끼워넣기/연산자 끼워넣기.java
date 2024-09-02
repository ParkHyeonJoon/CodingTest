import java.util.Scanner;

public class Main {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] operator = new int[4];
    public static int[] number;
    public static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        number = new int[N];

        // 숫자 입력
        for(int i=0; i<N; i++) {
            number[i] = scanner.nextInt();
        }

        // 연산자 입력
        for(int i=0; i<4; i++) {
            operator[i] = scanner.nextInt();
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int num, int idx) {
        if(N == idx) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for(int i=0; i<4; i++) {
            if(operator[i] > 0) {
                operator[i]--;

                switch(i) {
                    case 0: dfs(num+number[idx], idx+1); break;
                    case 1: dfs(num-number[idx], idx+1); break;
                    case 2: dfs(num*number[idx], idx+1); break;
                    case 3: dfs(num/number[idx], idx+1); break;
                }

                operator[i]++;
            }
        }
    }
}
