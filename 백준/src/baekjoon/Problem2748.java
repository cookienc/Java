package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2748
 */
public class Problem2748 {

	private static Long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		dp = new Long[n + 1];

		dp[0] = 0L;
		dp[1] = 1L;

		System.out.println(fibonacci(n));
	}

	private static Long fibonacci(int n) {
		if (dp[n] != null) {
			return dp[n];
		}

		dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

		return dp[n];
	}
}
