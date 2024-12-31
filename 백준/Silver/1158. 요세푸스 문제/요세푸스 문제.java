import java.util.*;
public class Main {

    static int N;
    static int K;
    static List<Integer> list = new LinkedList<>();
    static List<Integer> answerList = new LinkedList<>();

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        for(int i=1; i<=N; i++) {
            list.add(i);
        }
    }

    static void pro() {
        for(int i=0; i<N; i++) {
            int index = K - 1;
            while(index-- > 0) {
                list.add(list.remove(0));
            }

            answerList.add(list.remove(0));
        }

        System.out.print("<");
        for(int i=0; i<answerList.size(); i++) {
            System.out.print(answerList.get(i));
            if(i < answerList.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}