import java.io.*;
import java.util.*;

public class Main {
    static String word;
    static int[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[30];
        word = br.readLine();
    }

    static void pro() {
        word = word.toLowerCase();
        for(char c : word.toCharArray()) {
            int index = c - 'a';
            arr[index]++;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        boolean isDuplicated = false;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
                isDuplicated = false;
            } else if(arr[i] == max) {
                isDuplicated = true;
            }
        }

        if(isDuplicated) {
            System.out.println("?");
        } else {
            int ans = maxIndex + 'A';
            char c = (char) ans;
            System.out.println(c);
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
