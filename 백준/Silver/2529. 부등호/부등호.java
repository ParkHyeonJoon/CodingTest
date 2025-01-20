import java.io.*;
import java.util.*;

public class Main {
   static int k;
   static char[] inequality;
   static boolean[] visited;
   static int[] arr;
   static String min = "9999999999";
   static String max = "0";

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        inequality = br.readLine().replace(" ", "").toCharArray();
        visited = new boolean[10];
        arr = new int[k+1];
    }

    static void rec(int count) {
        // count == k+1 이면 수식이 완료
        if(count == k+1) {
            StringBuilder sb = new StringBuilder();
            // 수식에 있는 숫자를 그대로 하나씩 꺼내서 StringBuilder에 붙이고
            for (int i = 0; i < k+1; i++) { // 사용된 숫자만 추가
                sb.append(arr[i]);
            }
            String num = sb.toString();
            // 최댓값과 최솟값 갱신
            if (num.compareTo(max) > 0) max = num;
            if (num.compareTo(min) < 0) min = num;
            return;
        }
        // base case를 충족하지 못한다면
        // i는 수식에 들어갈 숫자
        for(int i=0; i<10; i++) {
            // i가 수식에 들어있지 않은 수라면
            if(!visited[i]) {
                // i가 checkCondition메서드에서 true를 받으면
                if(count == 0 || checkCondition(arr[count-1], i, inequality[count-1])) {
                    arr[count] = i;
                    visited[i] = true;
                    // 다음 위치로 진행
                    rec(count+1);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean checkCondition(int prev, int now, char op) {
        if(op == '<') {
            return prev < now;
        } else {
            return prev > now;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec(0);
        System.out.println(max);
        System.out.println(min);
    }
}
