import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static List<String> list = new ArrayList<>();
    static StringBuilder password;
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        list.sort(String::compareTo);
    }
    static void rec(StringBuilder password, int index, int vowelCount, int consonantCount) {
        // Base Case
        if(password.length() == L) {
            // 암호가 조건에 맞는지
            // 모음 최소 1개, 자음 최소 2개
            if(vowelCount >= 1 && consonantCount >= 2) {
                System.out.println(password.toString());
            }
            return;
        }

        // Recursion Case
        for(int i=index; i<C; i++) {
            char c = list.get(i).charAt(0);
            password.append(c);
            
            // 모음 여부 판단
            if(isVowel(c)) {
                rec(password, i+1, vowelCount+1, consonantCount);
            } else {
                rec(password, i+1, vowelCount, consonantCount+1);
            }

            password.deleteCharAt(password.length() - 1);
        }
    }

    static boolean isVowel(char c) {
        for(char v : vowels) {
            if(c == v) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        input();
        password = new StringBuilder();
        rec(password, 0, 0, 0);
    }
}
