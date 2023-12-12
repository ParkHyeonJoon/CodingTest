package implementation.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2444 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i <= 2*n-1; i++) {
            int j = 0;
            if(i - n < 0) {
                j = -(i - n);
                for(int k=0; k<j; k++) {
                    System.out.print(" ");
                }
                for(int p=0; p<(i-1)+i; p++) {
                    System.out.print("*");
                }
                System.out.println();
            } else if(i - n > 0) {
                j = i - n;
                for(int k=0; k<j; k++) {
                    System.out.print(" ");
                }
                for(int p=0; p < (2*n-1)-2*j; p++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for(int k=0; k<2*n-1; k++)
                    System.out.print("*");
                System.out.println();
            }
        }
    }
}
