import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer> list = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void pro() {
        list.sort(Integer::compare);

        if(N == 1) {
            int num = list.get(0);
            System.out.println(num*num);
        } else {
            int num1 = list.get(0);
            int num2 = list.get(N-1);
            System.out.println(num1*num2);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
