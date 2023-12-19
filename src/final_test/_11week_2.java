package final_test;

import java.util.Scanner;

public class _11week_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static int solution(String s) {
        int answer = s.length();
        int len = s.length();

        // 길이가 1이라면 탐색의 필요X
        if(len == 1) {
            return 1;
        }

        for(int split=1; split<len/2 + 1; split++) {
            String str = new String();

            String comp = s.substring(0, split);
            int cnt = 1;

            for(int i=split; i<len; i += split) {
                if(i+split > len) {
                    if(cnt > 1)
                        str += cnt + comp;
                    else
                        str += comp;
                    comp = s.substring(i);
                    cnt = 1;
                    continue;
                }
                else if(comp.equals(s.substring(i, i+split)))
                    cnt++;
                else {
                    if(cnt > 1)
                        str += cnt+comp;
                    else
                        str += comp;
                    comp = s.substring(i, i+split);
                    cnt = 1;
                }
            }
            if(cnt > 1)
                str += cnt + comp;
            else
                str += comp;

            if(answer > str.length()) {
                answer = str.length();
            }
        }
        return answer;
    }
}
