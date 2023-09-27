package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 출처: https://www.acmicpc.net/problem/2688
 */
public class Problem2688 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[66][10];
        Arrays.fill(dp[1], 1);
        for (int n = 1; n <= 65; n++) {
            dp[n][0] = 1;
        }

        for (int n = 2; n <= 65; n++) {
            for (int c = 1; c <= 9; c++) {
                dp[n][c] = dp[n - 1][c] + dp[n][c - 1];
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N + 1][9]);
        }
    }
}
