import java.io.*;
import java.util.*;

public class Main {

    static int N, E;
    static List<Integer>[] arr;
    static boolean[] visited;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new List[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int i=1; i<=E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        visited = new boolean[N+1];
    }

    static void pro() {
        int count = 0;
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                count++;
                dfs(arr, i, visited);
            }
        }
        System.out.println(count);
    }

    static void dfs(List<Integer>[] arr, int v, boolean[] visited) {
        if(!visited[v]) {
            visited[v] = true;
            for(int i : arr[v]) {
                dfs(arr, i, visited);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
