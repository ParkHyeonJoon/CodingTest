package final_test.까다로운미로;

import java.util.*;

public class Solution {
    // 나의 현재 좌표랑 현재 방향 정보
    static class State {
        int r, c;
        String dir;
        String path;

        State(int r, int c, String dir, String path) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.path = path;
        }
    }

    public static String solution(String[] maze) {
        int n = maze.length;
        boolean[][][] visited =  new boolean[4][n][n];

        Map<String, int[]> dirs = new HashMap<>();
        dirs.put("U", new int[]{-1, 0});
        dirs.put("D", new int[]{1, 0});
        dirs.put("L", new int[]{0, 1});
        dirs.put("R", new int[]{0, -1});

        Map<String, Integer> dirIndex = new HashMap<>();
        dirIndex.put("U", 0);
        dirIndex.put("D", 1);
        dirIndex.put("L", 2);
        dirIndex.put("R", 3);

        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(0, 0, "R", ""));
        visited[dirIndex.get("R")][0][0] = true;

        while(!q.isEmpty()) {
            // 현재 좌표 방문
            State current = q.poll();
            int r = current.r;
            int c = current.c;
            String dir = current.dir;
            String path = current.path;

            if(r == n-1 && c == n-1) {
                return path;
            }

            // 상하좌우 방문
            for(String d : Arrays.asList("-", "U", "D", "L", "R")) {
                int nr = r, nc = c;
                String newPath = path + d;
                String newDir = dir;

                if(d.equals("-")) {
                    int[] delta = dirs.get(dir);
                    nr += delta[0];
                    nc += delta[1];
                } else {
                    int[] delta = dirs.get(d);
                    if(dir.equals(d)) {
                        nr += 3 * delta[0];
                        nc += 3 * delta[1];
                    } else {
                        nr += 2 * delta[0];
                        nc += 2 * delta[1];
                        newDir = d;
                    }
                }
                if(nr >= 0 && nc >= 0 && nr < n && maze[nr].charAt(nc) == '0' && !visited[])
            }
        }
    }

    public static void main(String[] args) {
        String[] maze1 = {"0..0.", ".....", "0.00.", "...0.", "00.00"};
        String[] maze2 = {"0..0..", "......", }
    }
}
