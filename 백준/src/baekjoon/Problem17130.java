package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem17130 {

    private static final char CAN_MOVE = '.';
    private static final char CARROT = 'C';
    private static final char WALL = '#';
    private static final char HOLE = 'O';
    private static final char RABBIT = 'R';
    private static char[][] map;
    private static int R;
    private static int C;
    private static int answer = -1;
    private static int[] dr = {-1, 0, 1};
    private static int[] dc = {-1, -1, -1};
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        Queue<int[]> q = new LinkedList<>();
        int rr = 0;
        int rc = 0;
        for (int r = 0; r < R; r++) {
            final String value = bufferedReader.readLine();
            for (int c = 0; c < C; c++) {
                final char ch = value.charAt(c);
                if (ch == HOLE || ch == WALL) {
                    q.add(new int[]{r, c});
                }

                if (ch == RABBIT) {
                    rr = r;
                    rc = c;
                }
                map[r][c] = ch;
            }
        }

        dp = new int[R][C];
        for (int r = 0; r < R; r++) {
            Arrays.fill(dp[r], -1);
        }

        dp[rr][rc] = 0;

        for (int c = rc + 1; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (map[r][c] == WALL) {
                    continue;
                }

                for (int i = 0; i < 3; i++) {
                    int br = r + dr[i];
                    int bc = c + dc[i];

                    if (isOver(br, bc)) {
                        continue;
                    }

                    if (map[br][bc] == CARROT && dp[br][bc] != -1) {
                        dp[r][c] = Math.max(dp[r][c], dp[br][bc] + 1);
                        continue;
                    }

                    dp[r][c] = Math.max(dp[r][c], dp[br][bc]);
                }
            }
        }

        for (int[] hole : q) {
            answer = Math.max(answer, dp[hole[0]][hole[1]]);
        }
        System.out.println(answer);
    }

    private static boolean isOver(final int br, final int bc) {
        return br < 0 || bc < 0 || br >= R || bc >= C;
    }
}
