package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1890
 */
public class Problem1890 {

	private static long[][] dp;
	private static int[][] array;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());

		dp = new long[N + 1][N + 1];
		array = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][1] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == N && j == N) {
					continue;
				}

				if (i + array[i][j] <= N) {
					dp[i + array[i][j]][j] += dp[i][j];
				}

				if (j + array[i][j] <= N) {
					dp[i][j + array[i][j]] += dp[i][j];
				}
			}
		}

		System.out.println(dp[N][N]);
	}

}
