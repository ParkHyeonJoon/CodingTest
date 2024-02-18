import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Scanner + Collections 사용
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<N; i++) {
            arr.add(sc.nextInt());
        }

        Collections.sort(arr);

        for(int value : arr) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}
