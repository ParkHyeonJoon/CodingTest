import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static boolean checkArrive;
    static List<Integer>[] relationList;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relationList = new ArrayList[N];
        checkArrive = false;

        for(int i=0; i<N; i++) {
            relationList[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            relationList[s].add(e);
            relationList[e].add(s);
        }
        visited = new boolean[N];
    }

    static void dfs(int start, int count) {
        if(count == 5 || checkArrive) {
            checkArrive = true;
            return;
        }

        visited[start] = true;

        for(int i=0; i<relationList[start].size(); i++) {
            int nextNode = relationList[start].get(i);
            if(!visited[nextNode]) {
                dfs(nextNode, count+1);
            }
        }
        visited[start] = false;
    }

    public static void main(String[] args) throws IOException {
        input();
        for(int i=0; i<N; i++) {
            dfs(i, 1);
            if(checkArrive) break;
        }
        if(checkArrive) System.out.println("1");
        else System.out.println("0");
    }
}
