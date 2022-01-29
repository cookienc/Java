package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2294
 */
public class Problem2294 {
	private static int[] dp;
	private static int N;
	private static int K;
	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[100_001];
		array = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i : array) {
			dp[i] = 1;
		}

		System.out.println(result());
	}

	private static int result() {
		for (int i = 1; i <= K; i++) {
			for (int j = 1; j <= N; j++) {
				if (i - array[j] < 1) {
					continue;
				}
				if (dp[i - array[j]] == Integer.MAX_VALUE) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - array[j]] + 1);
			}
		}
		if (dp[K] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[K];
	}
}
