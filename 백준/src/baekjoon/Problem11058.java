package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/11058
 */
public class Problem11058 {

	private static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new long[101];

		System.out.println(recur(N));
	}

	private static long recur(int n) {
		if (n <= 0) {
			return 0;
		}

		if (n < 7) {
			return n;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		for (int i = 2; i <= 4; i++) {
			dp[n] = Math.max(dp[n], recur(n - (i + 1)) * i);
		}

		return dp[n];
	}
}
