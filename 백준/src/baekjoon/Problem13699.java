package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/13699
 */
public class Problem13699 {

	private static long[] dp = new long[36];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				dp[i] += dp[j] * dp[i - 1 - j];
			}
		}

		System.out.println(dp[n]);

	}
}
