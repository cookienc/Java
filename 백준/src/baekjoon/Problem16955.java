package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem16955 {

    private static final int[] dr = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    private static final int[] dc = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
    private static final Character MINE = 'X';
    private static final Character EMPTY = '.';
    private static final char OTHER = 'O';
    private static char[][] map;

    /**
XXOXX.....
OX.OX.....
..O.X.....
...X......
....X.....
....X.....
..........
..........
..........
..........
      <p>
OXOX.X....
O..X......
..X.......
.X........
X.........
..........
..........
..........
..........
..........
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            final String input = br.readLine();
            for (int j = 0; j < 10; j++) {
                final char state = input.charAt(j);
                map[i][j] = state;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (check(i, j)) {
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }

        System.out.println(0);
    }

    private static boolean check(final int r, final int c) {
        if (map[r][c] == OTHER) {
            return false;
        }

        for (int d = 0; d < 8; d++) {
            int nextR = dr[d];
            int nextC = dc[d];

            int mine = 0;
            int empty = 0;

            if (map[r][c] == MINE) {
                mine++;
            } else {
                empty++;
            }

            int nr = r;
            int nc = c;
            for (int cnt = 0; cnt < 4; cnt++) {
                nr += nextR;
                nc += nextC;

                if (nr < 0 || nc < 0 || nr >= 10 || nc >= 10) {
                    continue;
                }

                if (map[nr][nc] == MINE) {
                    mine++;
                    continue;
                }
                if (map[nr][nc] == EMPTY) {
                    empty++;
                }
            }

            if (mine == 4 && empty == 1) {
                return true;
            }
        }
        return false;
    }

}
