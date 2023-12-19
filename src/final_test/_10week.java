package final_test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _10week {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i=0; i<n; i++) {
            numbers[i] = sc.nextInt();
        }

        _10week solution = new _10week();
        String result = solution.Solution(numbers);

        System.out.println(result);

    }
    public static String Solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length]; // 문자열 리턴 해줄 스트링배열 생성

        // int배열 -> String배열로 변환
        for(int i=0; i<numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        // 0값이 중복일 경우 ex){0, 0, 0}
        if(str[0].equals("0")) return "0";

        // 0이 아니면 문자열을 더해준다.
        for(String s : str) answer += s;

        return answer;
    }
}
