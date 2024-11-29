import java.util.*;
public class Main {

    static String word;
    static StringBuilder sb = new StringBuilder();

    static void input() {
        Scanner sc = new Scanner(System.in);
        word = sc.next();
    }

    static void pro() {
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int ascii = (int) c;
            if(65 <= ascii && ascii <= 90) {
                ascii += 32;
            } else {
                ascii -= 32;
            }
            char transformed = (char)ascii;
            sb.append(transformed);
        }
        System.out.print(sb.toString());
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}