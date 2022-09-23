package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2624
 */
public class Problem2624 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][M + 1];

		List<int[]> coins = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int coin = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			coins.add(new int[]{coin, cnt});
		}
		coins.add(new int[]{0, 0});

		coins.sort(Comparator.comparingInt(c -> c[0]));

		for (int i = 0; i <= N; i++) {
			dp[i][0] = 1;
		}

		for (int r = 1; r <= N; r++) {
			int[] coin = coins.get(r);
			int cost = coin[0];
			int total = coin[1];
			for (int c = 1; c <= M; c++) {
				for (int k = 0; k <= total; k++) {
					if (c - (cost * k) < 0) break;
					dp[r][c] += dp[r - 1][c - (cost * k)];
				}
			}
		}

		System.out.println(dp[N][M]);
	}
}