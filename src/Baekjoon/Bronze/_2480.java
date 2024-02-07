package Baekjoon.Bronze;

import java.util.Scanner;

public class _2480 {
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a; int b; int c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        if(a == b && a == c && b == c) {
            result = 10000 + a * 1000;
        } else if(a == b) {
            result = 1000 + a * 100;
        } else if(b == c) {
            result = 1000 + b * 100;
        } else if(a == c) {
            result = 1000 + a * 100;
        } else {
            if(a > b && a > c) {
                result = a * 100;
            } else if(a > b && c > a) {
                result = c * 100;
            } else if(b > a && b > c) {
                result = b * 100;
            }
        }
        System.out.println(result);
    }
}
