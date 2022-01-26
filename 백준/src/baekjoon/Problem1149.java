package baekjoon;

/**
 * 출처: https://www.acmicpc.net/problem/1149
 * 참조: https://st-lab.tistory.com/128
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1149 {

	private static int[][] map;
	private static int[][] dp;
	private static final int RED = 0;
	private static final int GREEN = 1;
	private static final int BLUE = 2;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		map = new int[N + 1][3];
		dp = new int[N + 1][3]; // [비용][색]

		StringTokenizer stringTokenizer;
		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		System.out.println(Math.min((Math.min(paint(N, RED), paint(N, BLUE))), paint(N, GREEN)));
	}

	private static int paint(int n, int color) {


		if (n == 1) {
			return map[n][color];
		}

		if (dp[n][color] == 0) {
			if (color == RED) {
				dp[n][RED] = Math.min(paint(n - 1, BLUE), paint(n - 1, GREEN)) + map[n][RED];
			}

			if (color == GREEN) {
				dp[n][GREEN] = Math.min(paint(n - 1, BLUE), paint(n - 1, RED)) + map[n][GREEN];
			}

			if (color == BLUE) {
				dp[n][BLUE] = Math.min(paint(n - 1, GREEN), paint(n - 1, RED)) + map[n][BLUE];
			}
		}

		return dp[n][color];
	}

}
