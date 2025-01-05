import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int sum;

    static List<Integer> list = new ArrayList<>();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[9];
        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
    }
    static void pro() {
        int ans1 = 0, ans2 = 0;
        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    ans1 = i;
                    ans2 = j;
                    break;
                }
            }
        }

        for(int i=0; i<9; i++) {
            if(i == ans1 || i == ans2) {
                continue;
            } else {
                list.add(arr[i]);
            }
        }

        list.sort((a, b) -> Integer.compare(a, b));
        for(int weight : list) {
            System.out.println(weight);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}