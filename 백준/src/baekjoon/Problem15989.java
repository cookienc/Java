package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/15989
 */
public class Problem15989 {

	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		makeArr(10000);
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
		}
	}

	private static void makeArr(int n) {
		dp = new int[10001][4];

		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for (int i = 4; i <= n; i++) {
			dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
			dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
			dp[i][1] = dp[i - 1][1];
		}
	}
}
