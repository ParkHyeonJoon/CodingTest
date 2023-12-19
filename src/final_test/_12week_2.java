package final_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _12week_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] arr = input.toCharArray();
        List<Character> result = new ArrayList<>();
        int value = 0;

        for(char item : arr) {
            if(Character.isAlphabetic(item)) {
                result.add(item);
            } else {
                value += item - '0';
            }
        }

        Collections.sort(result);
        for(Character ch : result) {
            System.out.print(ch);
        }
        if(value != 0)
            System.out.print(value);
    }
}
