package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem16469 {

    private static Deque<Villain> villains = new ArrayDeque<>();
    private static int R;
    private static int C;
    private static int[] dr = new int[]{-1, 0, 1, 0};
    private static int[] dc = new int[]{0, -1, 0, 1};
    private static int[][] map;
    private static int[][][] routes;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            final String m = br.readLine();
            for (int c = 0; c < C; c++) {
                final int value = m.charAt(c) - '0';
                map[r][c] = value;
            }
        }

        routes = new int[R][C][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            final int r = Integer.parseInt(st.nextToken()) - 1;
            final int c = Integer.parseInt(st.nextToken()) - 1;
            villains.add(new Villain(r, c, 0, i));
            routes[r][c][i] = -1;
        }

        bfs();

        int minTime = Integer.MAX_VALUE;
        int cnt = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                final int first = routes[r][c][0];
                final int second = routes[r][c][1];
                final int third = routes[r][c][2];
                if ((first == 0) || (second == 0) || (third == 0)) {
                    continue;
                }

                int tmp = Math.max(first, Math.max(second, third));

                if (minTime == tmp) {
                    cnt++;
                    continue;
                }

                if (minTime > tmp) {
                    minTime = tmp;
                    cnt = 1;
                }
            }
        }

        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(minTime);
        System.out.println(cnt);
    }

    private static void bfs() {
        while (!villains.isEmpty()) {
            boolean[][][] isVisited = new boolean[R][C][3];

            while (!villains.isEmpty()) {
                final Villain cur = villains.pop();
                final int cr = cur.r;
                final int cc = cur.c;
                final int name = cur.name;
                final int distance = cur.distance;

                isVisited[cr][cc][name] = true;

                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];

                    if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                        continue;
                    }

                    if (map[nr][nc] == 1 || isVisited[nr][nc][name]) {
                        continue;
                    }

                    routes[nr][nc][name] = distance + 1;
                    isVisited[nr][nc][name] = true;
                    villains.add(new Villain(nr, nc, distance + 1, name));
                }
            }
        }
    }

    private static class Villain {
        int r;
        int c;
        int distance;
        int name;

        public Villain(final int r, final int c, final int distance, final int name) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.name = name;
        }
    }
}
