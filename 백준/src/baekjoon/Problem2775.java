package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2775
 */
public class Problem2775 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        final StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            final int C = Integer.parseInt(br.readLine());
            final int R = Integer.parseInt(br.readLine());

            int[][] apart = new int[C + 1][R + 1];
            for (int c = 0; c <= C; c++) {
                for (int r = 1; r <= R; r++) {
                    if (c == 0) {
                        apart[c][r] = r;
                        continue;
                    }

                    if (r == 1) {
                        apart[c][r] = 1;
                        continue;
                    }

                    apart[c][r] = apart[c][r - 1] + apart[c - 1][r];
                }
            }

            sb.append(apart[C][R]).append("\n");
        }
        System.out.println(sb);
    }
}
