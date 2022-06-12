package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11049
 */
public class Problem11049 {
	private static int n;
	private static final int INF = Integer.MAX_VALUE;
	private static int[] data;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		data = new int[n + 1];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			data[i] = a;
			data[i + 1] = b;
		}

		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], INF);
		}
		System.out.println(solve(0, n - 1));
	}

	private static int solve(int start, int end) {
		if (start == end) {
			return 0;
		}

		if (dp[start][end] != INF) {
			return dp[start][end];
		}

		for (int i = start; i < end; i++) {
			int value = solve(start, i) + solve(i + 1, end) + (data[start] * data[i + 1] * data[end + 1]);
			dp[start][end] = Math.min(dp[start][end], value);
		}

		return dp[start][end];
	}
}
