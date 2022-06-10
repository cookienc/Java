package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11066
 * 참조: https://www.youtube.com/watch?v=4OdIDIYLHlY&ab_channel=%EB%A1%9C%EB%B0%8D%EB%A7%A8
 */
public class Problem11066 {

	private static int K;
	private static int[] files;
	private static int[][] dp;
	private static final StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			K = Integer.parseInt(br.readLine());
			files = new int[K];
			dp = new int[K][K];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < K; i++) {
				files[i] = Integer.parseInt(st.nextToken());
			}

			for (int c = 1; c < K; c++) {
				for (int r = c - 1; r >= 0; r--) {
					int min = Integer.MAX_VALUE;
					for (int k = 0; k < c - r; k++) {
						min = Math.min(min, dp[r][r + k] + dp[r + k + 1][c]);
					}
					dp[r][c] = min + sum(r, c);
				}
			}
			sb.append(dp[0][K - 1]).append("\n");
		}

		System.out.println(sb);
	}

	private static int sum(int r, int c) {
		int sum = 0;
		for (int i = r; i <= c; i++) {
			sum += files[i];
		}
		return sum;
	}
}
