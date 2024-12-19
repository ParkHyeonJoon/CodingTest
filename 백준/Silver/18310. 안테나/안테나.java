import java.util.*;
public class Main {

    static int N;
    static int[] arr;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void pro() {
        Arrays.sort(arr);
        int middle = arr[(N-1)/2];

        System.out.println(middle);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}