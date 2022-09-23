package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 출처: https://www.acmicpc.net/problem/2631
 */
public class Problem2631 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] children = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			children[i] = Integer.parseInt(br.readLine());
		}

		int[] flag = children.clone();
		Arrays.sort(flag);

		int[][] dp = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (children[c] == flag[r]) {
					dp[r][c] = dp[r - 1][c - 1] + 1;
				} else {
					dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
				}
			}
		}
		System.out.println(N - dp[N][N]);
	}
}
