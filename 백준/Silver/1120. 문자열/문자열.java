import java.util.*;
public class Main {

    static String A;
    static String B;

    static void input() {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        B = sc.next();
    }

    static void pro() {
        int result = Integer.MAX_VALUE;
        
        for(int i=0; i<=B.length() - A.length(); i++) {
            int count = 0;
            for(int j=0; j<A.length(); j++) {
                if(A.charAt(j) != B.charAt(j+i)) {
                    count++;
                }
            }
            result = Math.min(result, count);
        }

        System.out.print(result);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}