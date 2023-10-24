package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14600 {

    private static int[][][] tiles = {
            {
                    {1, 1},
                    {1, 0},
            },
            {
                    {1, 0},
                    {1, 1},
            },
            {
                    {0, 1},
                    {1, 1},
            },
            {
                    {1, 1},
                    {0, 1},
            }
    };
    private static int[][] answer = null;
    private static int size = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, K);
        int[][] floors = new int[size][size];

        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int R = Integer.parseInt(st.nextToken()) - 1;
        final int C = Integer.parseInt(st.nextToken()) - 1;
        floors[size - C - 1][R] = -1;

        tiling(floors, 1);

        if (answer == null) {
            System.out.println(-1);
            return;
        }

        for (int[] tile : answer) {
            for (int t : tile) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
    }

    private static void tiling(final int[][] floors, int color) {

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                for (final int[][] tile : tiles) {
                    if (cannotAttach(floors, r, c, tile)) {
                        continue;
                    }
                    attach(floors, r, c, tile, color);
                    tiling(floors, color + 1);

                    boolean fill = true;
                    for (final int[] floor : floors) {
                        for (final int i : floor) {
                            if (i == 0) {
                                fill = false;
                                break;
                            }

                            if (!fill) {
                                break;
                            }
                        }
                    }

                    if (fill) {
                        answer = floors;
                        return;
                    }

                    detach(floors, r, c, tile);
                }
            }
        }
    }

    private static void attach(final int[][] floors, final int nr, final int nc, final int[][] tile, final int color) {
        for (int r = nr; r < nr + 2; r++) {
            for (int c = nc; c < nc + 2; c++) {
                if (floors[r][c] == -1) {
                    continue;
                }
                int tileR = r % 2;
                int tileC = c % 2;
                if (tile[tileR][tileC] == 0) {
                    continue;
                }
                floors[r][c] = color;
            }
        }
    }

    private static void detach(final int[][] floors, final int nr, final int nc, final int[][] tile) {
        for (int r = nr; r < nr + 2; r++) {
            for (int c = nc; c < nc + 2; c++) {
                if (floors[r][c] == -1) {
                    continue;
                }

                int tileR = r % 2;
                int tileC = c % 2;
                if (tile[tileR][tileC] == 0) {
                    continue;
                }

                floors[r][c] = 0;
            }
        }
    }

    private static boolean cannotAttach(final int[][] floors, final int nr, final int nc, final int[][] tile) {
        boolean cannotAttach = true;
        for (int r = nr; r < nr + 2; r++) {
            for (int c = nc; c < nc + 2; c++) {
                if (r >= size || c >= size) {
                    return true;
                }

                int tileR = r % 2;
                int tileC = c % 2;

                if (floors[r][c] == -1 && tile[tileR][tileC] == 1) {
                    return true;
                }

                if (floors[r][c] != -1 && floors[r][c] != 0) {
                    return true;
                }

                cannotAttach = false;
            }
        }

        return cannotAttach;
    }
}
