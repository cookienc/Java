package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10709 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int R = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        int[][] clouds = initializeClouds(R, C);
        settingClouds(br, R, C, clouds);

        for (int r = 0; r < R; r++) {
            for (int c = 1; c < C; c++) {
                final int before = clouds[r][c - 1];
                final int cur = clouds[r][c];
                if (before == -1 || cur == 0) {
                    continue;
                }

                clouds[r][c] = before + 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(clouds[r][c]).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    private static int[][] initializeClouds(final int R, final int C) {
        int[][] clouds = new int[R][C];

        for (int r = 0; r < R; r++) {
            Arrays.fill(clouds[r], -1);
        }
        return clouds;
    }

    private static void settingClouds(final BufferedReader br, final int R, final int C, final int[][] clouds) throws IOException {
        for (int r = 0; r < R; r++) {
            final String cloud = br.readLine();
            for (int c = 0; c < C; c++) {
                final char cur = cloud.charAt(c);
                if (cur == 'c') {
                    clouds[r][c] = 0;
                }
            }
        }
    }
}
