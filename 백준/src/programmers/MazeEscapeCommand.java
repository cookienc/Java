package programmers;

public class MazeEscapeCommand {

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int x = 2;
        int y = 3;
        int r = 3;
        int c = 1;
        int k = 5;

        final Solution solution = new Solution();
        System.out.println(solution.solution(n, m, x, y, r, c, k));
    }

    static class Solution {
        private static final String IMPOSSIBLE = "impossible";
        private static int[][] map;
        private static int R;
        private static int C;
        private static int ER;
        private static int EC;
        private static int DISTANCE;
        private static String answer = "";
        private static final int[] dr = {1, 0, 0, -1};
        private static final int[] dc = {0, -1, 1, 0};
        private static final String[] commands = new String[]{"d", "l", "r", "u"};

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            R = n;
            C = m;
            ER = r - 1;
            EC = c - 1;
            DISTANCE = k;
            map = new int[R][C];
            map[x - 1][y - 1] = -1;
            map[r - 1][c - 1] = -100;

            if (k > Math.abs(r - x) + Math.abs(c - y)) {
                findRoute(x - 1, y - 1, new StringBuilder(), 0);
            }

            if (answer.isEmpty()) {
                return IMPOSSIBLE;
            }

            return answer.toString();
        }

        private void findRoute(final int r, final int c, final StringBuilder route, final int depth) {
            if (!answer.isEmpty()) {
                return;
            }

            final int manhattan = Math.abs(ER - r) + Math.abs(EC - c);
            final int diff = DISTANCE - depth;
            if (manhattan > diff) {
                return;
            }

            if ((diff - manhattan) % 2 == 1) {
                return;
            }

            if (depth == DISTANCE && map[r][c] == -100) {
                answer = route.toString();
                return;
            }

            for (int i = 0; i < 4; i++) {
                final int nr = r + dr[i];
                final int nc = c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                findRoute(nr, nc, route.append(commands[i]), depth + 1);
                route.setLength(route.length() - 1);
            }
        }
    }
}
