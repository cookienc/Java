package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/17070
 */
public class Problem17070 {

	private static int N;
	private static int[][] map;
	private static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		initializeMap(br);

		dp = new int[N + 1][N + 1][3];
		dp[1][2][0] = 1;
		dynamic();

		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
	}

	private static void dynamic() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (map[r][c] == 1) {
					continue;
				}
				dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2];
				dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2];

				if (map[r - 1][c] == 1 || map[r][c - 1] == 1) {
					continue;
				}

				dp[r][c][2] += dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
			}
		}
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		map = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
