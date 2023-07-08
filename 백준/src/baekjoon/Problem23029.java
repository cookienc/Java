package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem23029 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        int[] food = new int[N + 1];
        for (int i = 1; i < food.length; i++) {
            food[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][3];
        dp[1][0] = 0; // 안 먹음
        dp[1][1] = food[1]; // 이전이랑 현재 둘 다 먹음
        dp[1][2] = food[1]; // 현재만 먹음

        if (N != 1) {
            dp[2][0] = food[1];
            dp[2][1] = food[2] / 2 + food[1];
            dp[2][2] = food[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = food[i] / 2 + Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = food[i] + dp[i - 1][0];
        }

        System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
    }
}
