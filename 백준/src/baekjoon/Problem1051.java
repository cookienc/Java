package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1051 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        for (int i = 0; i < N; i++) {
            final char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[j][i] = chars[j] - '0';
            }
        }

        final int maxSize = Math.min(M, N);

        int answer = 0;
        for (int s = 0; s <= maxSize; s++) {
            for (int c = 0; c < N; c++) {
                final int h = c + s;
                if (h >= N) {
                    continue;
                }

                for (int r = 0; r < M; r++) {
                    final int w = r + s;

                    if (w >= M) {
                        continue;
                    }

                    final int a = map[r][c];
                    final int b = map[w][c];
                    final int cc = map[r][h];
                    final int d = map[w][h];

                    if (a == b && d == cc && b == cc) {
                        answer = Math.max(answer, s + 1);
                    }
                }
            }
        }
        System.out.println((int) Math.pow(answer, 2));
    }
}
