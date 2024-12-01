import java.util.*;
public class Main {

    static int N;
    static List<String> list = new ArrayList<>();

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<N; i++) {
            list.add(sc.nextLine());
        }
    }

    static void pro() {
        list.sort((o1, o2) -> {
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int a = 0;
                int b = 0;
                for(int i=0; i<o1.length(); i++) {
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    if(num1 > 0 && num1 < 10) {
                        a += num1;
                    }
                    if(num2 > 0 && num2 < 10) {
                        b += num2;
                    }
                }
                if(a == b) {
                    return o1.compareToIgnoreCase(o2);
                }
                return a - b;
            }
        });
        list.forEach(System.out::println);
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}