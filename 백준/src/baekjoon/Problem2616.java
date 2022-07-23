package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2616
 */
public class Problem2616 {

	private static int[] sections;
	private static int[][] dp;
	private static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sections = new int[N];
		sum = new int[N];
		dp = new int[3][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sections[i] = Integer.parseInt(st.nextToken());
		}
		int K = Integer.parseInt(br.readLine());
		sum(N, K);
		find(N, K);
		System.out.println(dp[2][N - 1]);
	}

	private static void find(int n, int k) {
		for (int i = 0; i < 3; i++) {
			dp[i][0] = sections[0];
		}

		for (int i = 1; i < n; i++) {
			if (i >= k) {
				dp[0][i] = Math.max(dp[0][i - 1], sum[i]);
				continue;
			}
			dp[0][i] = dp[0][i - 1] + sections[i];
		}

		for (int i = 1; i < 3; i++) {
			 for (int j = 1; j < n; j++) {
				if (j < k) {
					dp[i][j] = sum[j];
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j - 1],
						Math.max(dp[i - 1][j - k] + sum[j], dp[i][j - 1]));
			}
		}
	}

	private static void sum(int n, int k) {

		int start = 0;
		int end = 0;
		int tmp = sections[start];

		while (end < n) {
			if (end - start == k - 1) {
				sum[end++] = tmp;
				if (end == n) {
					break;
				}
				tmp += sections[end];

				tmp -= sections[start++];
				continue;
			}
			sum[end++] = tmp;
			if (end != n - 1) {
				tmp += sections[end];
			}
		}
	}
}
