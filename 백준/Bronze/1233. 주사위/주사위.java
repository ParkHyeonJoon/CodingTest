import java.util.*;
public class Main {

    static int S1, S2, S3;
    static int[] countCheck;

    static void input() {
        Scanner sc = new Scanner(System.in);
        S1 = sc.nextInt();
        S2 = sc.nextInt();
        S3 = sc.nextInt();
    }

    static void pro() {
        countCheck = new int[16001];
        for(int i=1; i<=S1; i++) {
            for(int j=1; j<=S2; j++) {
                for(int k=1; k<=S3; k++) {
                    int sum = i + j + k;
                    countCheck[sum]++;
                }
            }
        }

        int maxCount = 0;
        int result = 0;
        for(int i=0; i<countCheck.length; i++) {
            if(countCheck[i] > maxCount) {
                maxCount = countCheck[i];
                result = i;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}