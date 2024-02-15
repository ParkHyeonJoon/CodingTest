import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<arr.length; i++) {
            int minIndex = 0;
            for(int j = minIndex+1; j<arr.length; j++) {
                if(arr[minIndex] > arr[j]) {
                    int temp = arr[minIndex];
                    arr[minIndex] = arr[j];
                    arr[j] = temp;
                }
                minIndex++;
            }
        }

        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}