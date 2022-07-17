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
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;
		dp[5] = 5;
		dp[6] = 6;

		for (int i = 7; i <= 100; i++) {
			for (int j = 2; j <= 4; j++) {
				dp[i] = Math.max(dp[i], dp[i - j - 1] * j);
			}
		}

		System.out.println(dp[N]);
	}
}
