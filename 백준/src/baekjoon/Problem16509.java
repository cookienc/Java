package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem16509 {

    private static int[][][] directions = {
            {{-1, 0}, {-1, 1}, {-1, 1}},
            {{-1, 0}, {-1, -1}, {-1, -1}},
            {{1, 0}, {1, 1}, {1, 1}},
            {{1, 0}, {1, -1}, {1, -1}},
            {{0, -1}, {1, -1}, {1, -1}},
            {{0, -1}, {-1, -1}, {-1, -1}},
            {{0, 1}, {1, 1}, {1, 1}},
            {{0, 1}, {-1, 1}, {-1, 1}}
    };


    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int sr = Integer.parseInt(st.nextToken());
        final int sc = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        final int kr = Integer.parseInt(st.nextToken());
        final int kc = Integer.parseInt(st.nextToken());

        int[][] map = new int[10][9];
        map[kr][kc] = -1;

        System.out.println(bfs(map, sr, sc));
    }

    private static int bfs(final int[][] map, final int sr, final int sc) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.count));
        queue.add(new Node(sr, sc, 0));

        boolean[][] isVisited = new boolean[10][9];
        isVisited[sr][sc] = true;

        while (!queue.isEmpty()) {
            final Node cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                final int[][] curDirections = directions[i];
                boolean isBlocked = false;
                int nr = cur.r;
                int nc = cur.c;
                for (int j = 0; j < 3; j++) {
                    nr += curDirections[j][0];
                    nc += curDirections[j][1];

                    if (nr < 0 || nc < 0 || nr >= 10 || nc >= 9) {
                        isBlocked = true;
                        break;
                    }

                    if (j != 2 && map[nr][nc] == -1) {
                        isBlocked = true;
                        break;
                    }
                }

                if (isBlocked) {
                    continue;
                }

                if (isVisited[nr][nc]) {
                    continue;
                }

                isVisited[nr][nc] = true;

                if (map[nr][nc] == -1) {
                    return cur.count + 1;
                }

                queue.add(new Node(nr, nc, cur.count + 1));
            }
        }

        return -1;
    }

    private static class Node {
        int r;
        int c;

        int count;

        public Node(final int r, final int c, final int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}
