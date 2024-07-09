import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int fasterCar = 0;

        HashMap<String, Integer> inMap = new HashMap<String, Integer>();

        for(int i=0; i<N; i++) {
            // a 1, b 2, c 3, d 4
            inMap.put(sc.next(), i);
        }
        int[] outCarRanking = new int[N];
        for(int i=0; i<N; i++) {
            String outCar = sc.next();
            outCarRanking[i] = inMap.get(outCar);
        }

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(outCarRanking[i] > outCarRanking[j]) {
                    fasterCar++;
                    break;
                }
            }
        }

        System.out.print(fasterCar);
    }
}
