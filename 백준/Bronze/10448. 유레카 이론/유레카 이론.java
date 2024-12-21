import java.util.*;
public class Main {

    static int T;
    static int[] arr;
    static int[] triangleNum;
    static boolean[] check;

    static void input() {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        sc.nextLine();
        arr = new int[T];
        for(int i=0; i<T; i++) {
            arr[i] = sc.nextInt();
        }
    }

    static void pro() {
        // 1. 삼각수 배열 생성
        setTriangleNum();

        // 2. 가능한 모든 삼각수의 합을 미리 계산
        check = new boolean[1001];
        for(int i=1; i<=44; i++) {
            for(int j=1; j<=44; j++) {
                for(int k=1; k<=44; k++) {
                    int sum = triangleNum[i] + triangleNum[j] + triangleNum[k];
                    if(sum <= 1000) {
                        check[sum] = true; // 3개의 삼각수 합으로 표현 가능한 수 표시
                    }
                }
            }
        }

        // 3. 결과 출력
        for(int i=0; i<T; i++) {
            if(check[arr[i]]) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    static void setTriangleNum() {
        // 1000까지의 삼각수는 총 44개 존재
        // triangleNum 배열에 삼각수 생성
        triangleNum = new int[45];
        for(int i=1; i<=44; i++) {
            triangleNum[i] = (i* (i+1)) / 2;
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}