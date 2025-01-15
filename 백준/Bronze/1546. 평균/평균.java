import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        list.sort(Integer::compare);
    }
    static void pro() {
        long max = list.get(N-1);
        long sum = 0;
        for(int i=0; i<N; i++) {
            sum += list.get(i);
        }
        System.out.println(sum * 100.0 / max / N);
    }
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
