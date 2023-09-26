package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/28075
 */
public class Problem28075 {

    private static int N;
    private static int M;
    private static int answer;
    private static int[][] progress;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        progress = new int[2][3];
        for (int r = 0; r < 2; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                progress[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 3; c++) {
                dfs(r, c, 1, progress[r][c]);
            }
        }

        System.out.println(answer);
    }

    private static void dfs(final int r, final int c, final int depth, final int totoal) {
        if (depth == N) {
            if (totoal >= M) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (c == j) {
                    dfs(i, j, depth + 1, totoal + (progress[i][j] / 2));
                    continue;
                }
                dfs(i, j, depth + 1, totoal + progress[i][j]);
            }
        }
    }
}
