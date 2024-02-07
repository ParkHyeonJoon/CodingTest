package Baekjoon.Silver;

import java.util.Scanner;

public class _1463 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        count = 0;

        while(x > 1) {
            if(x%3 == 0) {
                x = x / 3;
                count++;
            } else if(x%3 != 0 && x > 2) {
                if(x%2 == 0) {
                    x = x / 2;
                    count++;
                }
                else if(x%2 != 0) {
                    x = x - 1;
                    count++;
                }
            } else {
                x = x - 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
