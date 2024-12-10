import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class 하늘다리 {

    static int N;
    static int[] heights;

    public static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 산의 개수 N 입력
        N = Integer.parseInt(reader.readLine());
        heights = new int[N];

        // 산의 높이 정보 입력
        String[] heightStrings = reader.readLine().split(" ");
        for(int i=0; i<N; i++) {
            heights[i] = Integer.parseInt(heightStrings[i]);
        }
    }

    public static void solution() {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;

        for(int i=0; i<N; i++) {

            // 현재 산의 높이 정보
            int curHeight = heights[i];

            // 현재 산의 높이보다 낮은 산들을 stack에서 제거
            while(!stack.isEmpty() && heights[stack.peek()] < curHeight) {
                stack.pop();
            }

            // 현재 산의 높이와 같은 높이의 산이 존재한다면 하늘다리 설치 가능
            if(!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                count++;
            }

            stack.push(i);
        }

        System.out.print(count);
    }

    public static void main(String[] args) throws Exception {
        input();
        solution();
    }
}