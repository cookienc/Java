package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11051
 */
public class Problem11051 {

	public static final int MOD = 10_007;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][N + 1];

		for (int[] i : dp) {
			Arrays.fill(i, -1);
		}

		System.out.println(combination(N, K));
	}

	private static int combination(int n, int c) {

		if (n == 1 || n == c || c == 0) {
			return dp[n][c] = 1;
		}

		if (c == 1) {
			return dp[n][c] = n;
		}

		if (dp[n][c] == -1) {
			dp[n][c] = (combination(n - 1, c - 1) % MOD + combination(n - 1, c) % MOD) % MOD;
		}

		return dp[n][c];

	}
}
