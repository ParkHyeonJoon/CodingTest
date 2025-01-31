import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;
    static int N;

    static class Edge {
        int e;
        int value;
        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Edge>();
        }
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            while(true) {
                int E = Integer.parseInt(st.nextToken());
                if(E == -1) {
                    break;
                }
                int V = Integer.parseInt(st.nextToken());
                A[S].add(new Edge(E, V));
            }
        }
        distance = new int[N+1];
        visited = new boolean[N+1];
    }

    static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(Edge i : A[now]) {
                int e = i.e;
                int v = i.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now] + v;
                }
            }
        }
    }

    static void pro() {
        bfs(1);
        int max = 1;
        for(int i=2; i<=N; i++) {
            if(distance[max] < distance[i]) {
                max = i;
            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
