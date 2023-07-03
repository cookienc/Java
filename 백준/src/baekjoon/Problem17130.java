package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem17130 {

    private static final int CAN_MOVE = 0;
    private static final int CARROT = 1;
    private static final int WALL = 2;
    private static final int HOLE = 9;
    private static final int RABBIT = 3;
    private static int[][] map;
    private static int[][] carrotMap;
    private static int[] dr = {0, -1, 1};
    private static int[] dc = {1, 1, 1};
    private static int R;
    private static int C;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        carrotMap = new int[R][C];
        int startR = 0;
        int startC = 0;
        for (int r = 0; r < R; r++) {
            final String value = br.readLine();
            for (int c = 0; c < C; c++) {
                final char ch = value.charAt(c);
                if (ch == '.') {
                    map[r][c] = CAN_MOVE;
                    continue;
                }

                if (ch == 'C') {
                    map[r][c] = CARROT;
                    continue;
                }

                if (ch == '#') {
                    map[r][c] = WALL;
                    continue;
                }

                if (ch == 'O') {
                    map[r][c] = HOLE;
                    continue;
                }

                startR = r;
                startC = c;
                map[r][c] = RABBIT;
            }
        }

        findRoute(startR, startC);
        System.out.println(answer);
    }

    private static void findRoute(final int startR, final int startC) {

        Queue<Rabbit> rabbits = new LinkedList<>();
        rabbits.add(new Rabbit(startR, startC, 0));
        boolean[][] isVisited = new boolean[R][C];
        isVisited[startR][startC] = true;

        while (!rabbits.isEmpty()) {
            final Rabbit rabbit = rabbits.poll();

            if (carrotMap[rabbit.r][rabbit.c] > rabbit.carrot) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                final int nr = rabbit.r + dr[i];
                final int nc = rabbit.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                    continue;
                }

                if (map[nr][nc] == WALL) {
                    continue;
                }

                int carrot = rabbit.carrot;
                if (map[nr][nc] == CARROT) {
                    carrot++;
                }

                if (isVisited[nr][nc] && carrotMap[nr][nc] >= carrot) {
                    continue;
                }

                isVisited[nr][nc] = true;
                carrotMap[nr][nc] = carrot;

                if (map[nr][nc] == HOLE) {
                    answer = Math.max(answer, carrot);
                }

                rabbits.add(new Rabbit(nr, nc, carrot));
            }
        }
    }

    private static class Rabbit {
        int r;
        int c;
        int carrot;

        public Rabbit(final int r, final int c, final int carrot) {
            this.r = r;
            this.c = c;
            this.carrot = carrot;
        }
    }
}
