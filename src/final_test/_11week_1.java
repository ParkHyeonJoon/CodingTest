package final_test;

import java.util.Scanner;

public class _11week_1 {
    static int Answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0; i<n; i++) {
            arr1[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            arr2[i] = sc.nextInt();
        }
        int row;

        for(int i=0; i<arr1.length; i++) {
            row = arr1[i] | arr2[i];

            System.out.printf("[");
            for(int j=arr1.length-1; j>=0; j--) {
                if( ((row >> j) & 1) == 1)
                    System.out.printf("#");
                else
                    System.out.printf(" ");
            }
            System.out.printf("]\n");

        }
    }
}
