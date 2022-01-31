package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11660
 */
public class Problem11660 {

	private static int[][] array;
	private static int[][] dp;
	private static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		array = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		initializeDp(N);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sum(x1, y1, x2, y2);

		}
		System.out.println(stringBuilder);
	}

	private static void sum(int x1, int y1, int x2, int y2) {
		int sum = 0;


		for (int i = x1; i <= x2; i++) {
			sum += dp[i][y2];
		}

		if (y1 != 1) {
			for (int i = x1; i <= x2; i++) {
				sum -= dp[i][y1 - 1];
			}
		}

		stringBuilder.append(sum).append("\n");
	}

	private static void initializeDp(int N) {
		for (int i = 1; i <= N; i++) {
			dp[i][1] = array[i][1];
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				dp[i][j] += dp[i][j - 1] + array[i][j];
			}
		}
	}
}
