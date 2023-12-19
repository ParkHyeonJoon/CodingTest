package final_test;

import java.util.Scanner;

public class _13week_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        String k_num = to_k_number(n, k);
        //System.out.println("진수 = " + k_num);
        for(String str : k_num.split("0")) {
            if(str.equals("")) continue;
            if(is_prime_num(Integer.parseInt(str))) {
                answer += 1;
            }
        };
        System.out.println(answer);
    }
    public static String to_k_number(int n, int k) {
        String ret = "";
        while(n > 0) {
            ret = (n % k) + ret;
            n = n / k;
        }
        return ret;
    }
    public static boolean is_prime_num(int k) {
        if( k == 2 || k == 3) return true;
        if( k % 2 == 0 || k < 2) return false;
        for(int i=2; i<Math.sqrt(k); i++) {
            if(k % i == 0) return false;
        }
        return true;
    }
}
