package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/12869
 */
public class Problem12869 {

	private static int[] scv;
	private static int[][][] dp;
	private static int[][] damage = {
			{-9, -3, -1},
			{-9, -1, -3},
			{-3, -1, -9},
			{-3, -9, -1},
			{-1, -3, -9},
			{-1, -9, -3}
	};
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		scv = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[scv[0] + 1][scv[1] + 1][scv[2] + 1];

		dfs(scv[0], scv[1], scv[2], 0);
		System.out.println(answer);
	}

	private static void dfs(int a, int b, int c, int cnt) {
		if (dp[a][b][c] != 0 && dp[a][b][c] <= cnt) {
			return;
		}

		if (a == 0 && b == 0 && c == 0) {
			answer = Math.min(answer, cnt);
			return;
		}
		dp[a][b][c] = cnt;

		for (int i = 0; i < 6; i++) {
			int na = Math.max(a + damage[i][0], 0);
			int nb = Math.max(b + damage[i][1], 0);
			int nc = Math.max(c + damage[i][2], 0);

			dfs(na, nb, nc, cnt + 1);
		}
	}
}
