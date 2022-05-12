package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1520
 */
public class Problem1520 {

	private static int[][] map;
	private static int[][] dp;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, -1, 0, 1};
	private static int R;
	private static int C;
	private static final int INF = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		dp = new int[R][C];

		for (int r = 0; r < R; r++) {
			Arrays.fill(dp[r], -1);
		}

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0, 0));
	}

	private static int dfs(int r, int c) {
		if (r == R - 1 && c == C - 1) {
			return 1;
		}

		if (dp[r][c] != -1) {
			return dp[r][c];
		}

		dp[r][c] = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
				continue;
			}

			if (map[r][c] <= map[nr][nc]) {
				continue;
			}

			dp[r][c] += dfs(nr, nc);
		}

		return dp[r][c];
	}
}
