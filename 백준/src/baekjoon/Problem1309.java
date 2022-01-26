package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1309
 */
public class Problem1309 {
	public static final int MOD = 9901;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		dp = new int[N + 1][2];

		dp[1][0] = 1;
		dp[1][1] = 2;

		for (int i = 2; i <= N; i++) {
			dp[i][0] = (dp[i - 1][0] % MOD+ dp[i - 1][1] % MOD) % MOD;
			dp[i][1] = (2 * dp[i - 1][0] % MOD + dp[i - 1][1] % MOD) % MOD;
		}

		System.out.println((dp[N][0] + dp[N][1]) % MOD);

	}
}
