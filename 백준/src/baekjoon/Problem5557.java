package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/5557
 */
public class Problem5557 {

	private static int N;
	private static int[] arr;
	private static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		dp = new long[N - 1][21];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[0][arr[0]] = 1;
		for (int i = 1; i < N - 1; i++) {
			int diff = arr[i];
			for (int j = 0; j <= 20; j++) {

				if (dp[i - 1][j] == 0) {
					continue;
				}

				int plus = j + diff;
				int minus = j - diff;

				if (plus <= 20) {
					dp[i][plus] += dp[i - 1][j];
				}

				if (minus >= 0) {
					dp[i][minus] += dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[N - 2][arr[N - 1]]);
	}
}
