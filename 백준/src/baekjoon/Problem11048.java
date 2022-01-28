package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11048
 */
public class Problem11048 {

	private static int[] dx = {1, 1, 0};
	private static int[] dy = {1, 0, 1};

	private static int[][] dp;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][M + 1];
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		initializeDp(N, M);

		for (int i = N - 1; i >= 1; i--) {
			for (int j = M - 1; j >= 1; j--) {
				findDp(i, j);
			}
		}
		System.out.println(dp[1][1]);
	}

	private static int findDp(int n, int m) {

		if (n == 0) {
			return dp[1][1];
		}

		if (dp[n][m] == -1) {
			dp[n][m] = Math.max(dp[n + dx[0]][m + dy[0]],
					Math.max(dp[n + dx[1]][m + dy[1]], dp[n + dx[2]][m + dy[2]]))
					+ map[n][m];
		}


		return dp[n][m];
	}

	private static void initializeDp(int N, int M) {
		for (int[] i : dp) {
			Arrays.fill(i, -1);
		}

		dp[N][M] = map[N][M];

		for (int i = M - 1; i >= 1; i--) {
			dp[N][i] = map[N][i] + dp[N][i + 1];
		}

		for (int i = N -1; i >= 1; i--) {
			dp[i][M] = map[i][M] + dp[i + 1][M];
		}
	}
}
