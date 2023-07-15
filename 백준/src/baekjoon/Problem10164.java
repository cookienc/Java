package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10164 {

    private static final int[] dr = new int[]{1, 0};
    private static final int[] dc = new int[]{0, 1};
    private static int from = 0;
    private static int to = 0;
    private static int R;
    private static int C;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        int rr = 0;
        int rc = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                cnt++;
                if (cnt == K) {
                    rr = r;
                    rc = c;
                    break;
                }
            }
        }

        if (K == 0) {
            dfsTo(0, 0, R, C);
            System.out.println(to);
        } else {
            dfsFrom(0, 0, rr, rc);
            dfsTo(rr, rc, R, C);
            System.out.println(from * to);
        }
    }

    private static void dfsFrom(final int sr, final int sc, final int er, final int ec) {
        if (sr == er && sc == ec) {
            from++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if (nr > er || nc > ec) {
                continue;
            }

            dfsFrom(nr, nc, er, ec);
        }
    }

    private static void dfsTo(final int sr, final int sc, final int er, final int ec) {
        if (sr == er - 1 && sc == ec - 1) {
            to++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if (nr >= R || nc >= C) {
                continue;
            }

            dfsTo(nr, nc, er, ec);
        }
    }
}
