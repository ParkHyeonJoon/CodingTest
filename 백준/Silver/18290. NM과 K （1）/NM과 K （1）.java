import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, answer = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
            	// 격자판
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 탐색 시작
		search(0, 0, 0, 0);
		System.out.println(answer);
	}

	private static void search(int cnt, int preR, int preC, int sum) {
    	// 숫자가 K개만큼 채워졌을시 값 리턴
		if (cnt == K) {
			answer = Math.max(answer, sum);
			return;
		}

		boolean notAdj;
        // preR : 시작 인덱스를 자신의 위치에서 시작
		for (int i = preR; i < N; i++) {
			for (int j = (preR == i ? preC : 0); j < M; j++) {
            	// 자기자신이 이미 true일 경우 다음으로 이동
				if (visited[i][j]) {
					continue;
				}

				notAdj = true;
                // 상, 하, 좌, 우 인접한 숫자인지 체크
				for (int dir = 0; dir < 4; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];

					if ((nr >= 0 && nr < N && nc >= 0 && nc < M) && (visited[nr][nc])) {
                    	//인접한 숫자가 존재할시 다음으로 넘어감 
						notAdj = false;
						break;
					}
				}

				// notAdj = true일시 인접하지 않는 숫자이므로,
                // 해당 map[i][j] 값을 더함
				if (notAdj) {
					visited[i][j] = true;
					search(cnt + 1, i, j, sum + map[i][j]);
					visited[i][j] = false;
				}
			}
		}
	}
}