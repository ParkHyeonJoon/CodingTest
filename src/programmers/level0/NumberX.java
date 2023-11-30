package programmers.level0;

import java.util.Scanner;

public class NumberX {
    public static void main(String[] args) {

    }
    class Solution {
        public int solution(int num1, int num2) {
            Scanner sc = new Scanner(System.in);
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            int result = 0;
            result = num1 * num2;
            return result;
        }
    }
}
