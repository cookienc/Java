package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16569 {

    private static int R;
    private static int C;
    private static int[][] maps;
    private static int[][] volcanos;
    private static boolean[][] isVisited;
    private static int maxHeight = 0;
    private static int minimumTime = Integer.MAX_VALUE;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        final int V = Integer.parseInt(st.nextToken());
        maps = new int[R][C];

        st = new StringTokenizer(br.readLine());
        final int sr = Integer.parseInt(st.nextToken()) - 1;
        final int sc = Integer.parseInt(st.nextToken()) - 1;

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                final int height = Integer.parseInt(st.nextToken());
                maps[r][c] = height;
            }
        }

        volcanos = new int[R][C];
        int minimumT = Integer.MAX_VALUE;
        for (int v = 0; v < V; v++) {
            st = new StringTokenizer(br.readLine());
            final int vr = Integer.parseInt(st.nextToken()) - 1;
            final int vc = Integer.parseInt(st.nextToken()) - 1;
            final int t = Integer.parseInt(st.nextToken());
            volcanos[vr][vc] = t;

            minimumT = Math.min(t, minimumT);
        }

        bfs(sr, sc, minimumT);
        System.out.println(maxHeight + " " + minimumTime);
    }

    private static void bfs(final int sr, final int sc, final int minimumT) {
        final PriorityQueue<JaeSang> pq = new PriorityQueue<>(Comparator.comparingInt(js -> js.time));
        pq.add(new JaeSang(sr, sc, maps[sr][sc], 0));

        isVisited = new boolean[R][C];
        isVisited[sr][sc] = true;

        maxHeight = maps[sr][sc];
        minimumTime = 0;

        // volcanos와 재상이가 따로 감
        for (int t = 0; t < R * C; t++) {
            if (isAllVolcanos()) {
                break;
            }

            // volcanos
            nextVolcanos(t);

            // 재상
            findRoute(pq, t);
        }
    }

    private static boolean isAllVolcanos() {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (volcanos[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void nextVolcanos(final int nextTime) {
        final Queue<int[]> pq = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (volcanos[r][c] != 0 && volcanos[r][c] < nextTime) {
                    pq.add(new int[]{r, c, volcanos[r][c]});
                }
            }
        }

        while (!pq.isEmpty()) {
            final int[] volcano = pq.poll();
            for (int i = 0; i < 4; i++) {
                final int nr = volcano[0] + dr[i];
                final int nc = volcano[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                volcanos[nr][nc] = volcano[2];
            }
        }
    }

    private static void findRoute(final PriorityQueue<JaeSang> pq, final int t) {
        while (!pq.isEmpty()) {
            if (pq.peek().time != t) {
                break;
            }

            final JaeSang cur = pq.poll();
            if (volcanos[cur.r][cur.c] != 0) {
                continue;
            }

            if (maxHeight < maps[cur.r][cur.c]) {
                maxHeight = maps[cur.r][cur.c];
                minimumTime = cur.time;
            }

            for (int i = 0; i < 4; i++) {
                final int nr = cur.r + dr[i];
                final int nc = cur.c + dc[i];

                if (nr < 0 | nc < 0 | nr >= R | nc >= C) {
                    continue;
                }

                if (isVisited[nr][nc] | volcanos[nr][nc] != 0) {
                    continue;
                }

                isVisited[nr][nc] = true;
                pq.add(new JaeSang(nr, nc, maps[nr][nc], cur.time + 1));
            }
        }
    }

    private static class JaeSang {
        int r;
        int c;
        int height;
        int time;

        public JaeSang(final int r, final int c, final int height, final int time) {
            this.r = r;
            this.c = c;
            this.height = height;
            this.time = time;
        }
    }
}
