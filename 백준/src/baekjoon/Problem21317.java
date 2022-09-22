package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/21317
 */
public class Problem21317 {
	private static int[][] arr;
	private static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][2];
		dp = new int[N + 1][2];
		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 2; i <= N; i++) {

			if (i > 2) {
				dp[i][0] = Math.min(dp[i - 1][0] + arr[i - 1][0], dp[i - 2][0] + arr[i - 2][1]);
			} else {
				dp[i][0] = arr[i - 1][0];
			}

			if (i < 4) {
				continue;
			}

			if (i >= 6) {
				dp[i][1] = Math.min(dp[i - 1][1] + arr[i - 1][0], Math.min(dp[i - 2][1] + arr[i - 2][1], dp[i - 3][0] + K));
			} else if (i == 5) {
				dp[i][1] = Math.min(dp[i - 1][1] + arr[i - 1][0], dp[i - 3][0] + K);
			} else if (i == 4) {
				dp[i][1] = K;
			}
		}

		if (dp[N][0] != 0 && dp[N][1] == 0) {
			System.out.println(dp[N][0]);
			return;
		}
		System.out.println(Math.min(dp[N][0], dp[N][1]));
	}
}
