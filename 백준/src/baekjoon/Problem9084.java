package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9084
 */
public class Problem9084 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			int[] money = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());

			int[][] dp = new int[N + 1][M + 1];

			for (int r = 1; r <= N; r++) {
				for (int c = 0; c <= M; c++) {
					if (c == 0) {
						dp[r][c] = 1;
						continue;
					}
					if (c - money[r] >= 0) {
						dp[r][c] = dp[r - 1][c] + dp[r][c - money[r]];
					} else {
						dp[r][c] = dp[r - 1][c];
					}
				}
			}

			sb.append(dp[N][M]).append("\n");
		}
		System.out.println(sb);
	}
}
