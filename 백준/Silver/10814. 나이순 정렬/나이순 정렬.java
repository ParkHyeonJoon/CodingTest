import java.util.*;
public class Main {
    static int N;
    static String[][] arr;

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();
        arr = new String[N][2];
        for(int i=0; i<N; i++) {
            String[] part = sc.nextLine().split(" "); // 입력값 나이와 이름 각각 분리
            arr[i][0] = part[0]; // 입력값 나이 저장
            arr[i][1] = part[1]; // 입력값 이름 저장
        }
    }

    static void pro() {
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0] == o2[0]) {
                    return 1;
                } else {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            }
        });

        for(int i=0; i<N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}