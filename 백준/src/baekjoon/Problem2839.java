package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2839
 */
public class Problem2839 {

	private static Long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		dp = new Long[5001];

		for (int i = 0; i <= 7; i++) {
			dp[i] = Long.MAX_VALUE;
		}

		dp[3] = 1L;
		dp[5] = 1L;
		dp[6] = 2L;

		long answer = findAnswer(N);

		if (answer == Long.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(answer);

	}

	private static Long findAnswer(int n) {

		if (dp[n] == null) {
			dp[n] = Math.min(findAnswer(n - 3), findAnswer(n - 5)) + 1;
		}

		return dp[n];
	}
}
