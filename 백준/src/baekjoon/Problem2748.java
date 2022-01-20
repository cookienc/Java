package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2748
 */
public class Problem2748 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		long[] dp = new long[n + 1];

		if (n == 0) {
			System.out.println(0);
			return;
		}
		dp[0] = 0;

		if (n == 1) {
			System.out.println(1);
			return;
		}
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		System.out.println(dp[n]);
	}
}
