import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arrS = new int[n+1];
        for(int i=1; i<=n; i++) {
            arrS[i] = arrS[i-1] + sc.nextInt();
        }

        for(int i=0; i<q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(arrS[b] - arrS[a-1]);
        }
    }
}
