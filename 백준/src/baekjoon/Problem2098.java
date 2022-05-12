package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2098
 */
public class Problem2098 {

	private static int[][] dp;
	private static int[][] map;
	private static int N;
	private static int start;
	private static int INF = 11_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][(1 << N) - 1];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 1 << 0));
	}

	private static int dfs(int cur, int bit) {

		if (Integer.bitCount(bit) == N) {

			if (map[cur][0] == 0) {
				return map[cur][0] = INF;
			}

			return map[cur][0];
		}

		if (dp[cur][bit] != INF) {
			return dp[cur][bit];
		}

		for (int i = 0; i < N; i++) {
			if ((bit & 1 << i) != 0 || map[cur][i] == 0) {
				continue;
			}

			dp[cur][bit] = Math.min(dp[cur][bit], dfs(i, bit | 1 << i) + map[cur][i]);
		}

		return dp[cur][bit];
	}
}