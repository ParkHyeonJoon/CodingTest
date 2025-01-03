import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N; // 바퀴수
    static int K; // 바퀴 돌리는 횟수
    static int[] countInfo; // 화살표 이동 횟수
    static String[] alphaInfo; // 알파벳 정보
    static String[] board; // 바퀴 배열


    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        countInfo = new int[K];
        alphaInfo = new String[K];
        board = new String[N];

        for(int i=0; i<K; i++) {
            String[] info = br.readLine().split(" ");
            countInfo[i] = Integer.parseInt(info[0]);
            alphaInfo[i] = info[1];
        }
    }
    static void pro() {
        Set<String> usedAlphabets = new HashSet<>(); // 이미 사용된 알파벳 추적
        int index = 0; // 현재 화살표가 가리키는 위치

        for(int i=0; i<K; i++) {
            index = (index + N - (countInfo[i] % N)) % N;

            // 이미 채워진 칸일 경우
            if(board[index] != null) {
                // 존재하는 알파벳과 새로운 알파벳 정보가 다를 경우
                if(!board[index].equals(alphaInfo[i])) {
                    System.out.println("!");
                    return; // 프로그램 종료
                }
            }
            // 빈 칸일 경우
            else {
                // 이미 사용된 알파벳인지 확인
                if(usedAlphabets.contains(alphaInfo[i])) {
                    System.out.println("!");
                    return; // 프로그램 종료
                }
                board[index] = alphaInfo[i];
                usedAlphabets.add(alphaInfo[i]);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            int pos = (index + i) % N;
            sb.append(board[pos] == null ? "?" : board[pos]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}