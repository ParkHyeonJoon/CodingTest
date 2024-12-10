import java.util.*;
public class Main {
    static int N;
    static String[] personInfo;
    static List<Integer> list;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<N; i++) {
            personInfo[i] = sc.nextLine();
        }
    }

    static void pro() {
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(Arrays.toString(personInfo[i].split(" "))));
        }


    }
    public static void main(String[] args) {
        input();
        pro();
    }
}