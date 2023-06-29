package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem2636 {

    private static int[][] map;
    private static boolean[][] isVisited;
    private static int C;
    private static int R;
    private static int[] dr = {0, -1, 0, 1};
    private static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[C][R];

        int total = 0;
        for (int c = 0; c < C; c++) {
            st = new StringTokenizer(br.readLine());
            for (int r = 0; r < R; r++) {
                final int cheese = Integer.parseInt(st.nextToken());
                map[c][r] = cheese;

                if (cheese == 1) {
                    total++;
                }
            }
        }

        int cnt = 0;
        while (true) {
            cnt++;
            paint();
            delete();
            final int cheese = countCheese();
            if (cheese == 0) {
                break;
            }

            total = cheese;
        }

        System.out.println(cnt);
        System.out.println(total);
    }

    private static int countCheese() {
        int sum = 0;
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (map[c][r] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void paint() {
        int color = 2;
        isVisited = new boolean[C][R];
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (!isVisited[c][r] && map[c][r] != 1) {
                    paint(c, r, color++);
                }
            }
        }
    }

    private static void delete() {
        Deque<int[]> q = new ArrayDeque<>();
        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (map[c][r] != 1) {
                    continue;
                }

                boolean nextAir = false;
                for (int i = 0; i < 4; i++) {
                    int nc = c + dc[i];
                    int nr = r + dr[i];

                    if (nc < 0 || nr < 0 || nc >= C || nr >= R) {
                        continue;
                    }

                    if (map[nc][nr] == 2) {
                        nextAir = true;
                    }
                }

                if (nextAir) {
                    q.add(new int[]{c, r});
                }
            }
        }

        while (!q.isEmpty()) {
            final int[] poll = q.poll();
            map[poll[0]][poll[1]] = 2;
        }
    }

    private static void paint(final int c, final int r, final int color) {
        if (map[c][r] == 1) {
            return;
        }

        map[c][r] = color;
        isVisited[c][r] = true;

        for (int i = 0; i < 4; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];

            if (nc < 0 || nr < 0 || nc >= C || nr >= R) {
                continue;
            }

            if (isVisited[nc][nr] || map[nc][nr] == 1) {
                continue;
            }

            paint(nc, nr, color);
        }
    }
}
