package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/9251
 */
public class Problem9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chars1 = br.readLine().toCharArray();
		char[] chars2 = br.readLine().toCharArray();

		int N = chars1.length;
		int M = chars2.length;
		int[][] dp = new int[N + 1][M + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				if (chars2[c - 1] == chars1[r - 1]) {
					dp[r][c] = dp[r - 1][c - 1] + 1;
				} else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
