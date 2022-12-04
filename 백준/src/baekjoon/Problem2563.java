package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2563
 */
public class Problem2563 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] map = new int[100][100];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int R = Integer.parseInt(st.nextToken()) - 1;
            final int C = Integer.parseInt(st.nextToken()) - 1;

            for (int r = R; r < R + 10; r++) {
                for (int c = C; c < C + 10; c++) {
                    map[r][c] = 1;
                }
            }
        }

        int sum = 0;
        for (int r = 0; r < 100; r++) {
            for (int c = 0; c < 100; c++) {
                if (map[r][c] == 1) {
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }
}
