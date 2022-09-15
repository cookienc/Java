package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14620
 */
public class Problem14620 {

	private static int[][] G;
	private static int[] isPlanted;
	private static int N;
	private static int min = Integer.MAX_VALUE;
	private static int[] dr = {0, 0, -1, 0, 1};
	private static int[] dc = {0, -1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		G = new int[N][N];
		isPlanted = new int[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println(min);
	}

	private static void dfs(int depth, int price) {
		if (depth == 3) {
			min = Math.min(min, price);
			return;
		}

		for (int r = 1; r < N - 1; r++) {
			for (int c = 1; c < N - 1; c++) {
				if (cannotPlant(r, c)) {
					continue;
				}

				int sum = sum(r, c);
				plant(r, c);
				dfs(depth + 1, price + sum);
				pick(r, c);
			}
		}
	}

	private static boolean cannotPlant(int r, int c) {
		for (int i = 0; i < 5; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if ((isPlanted[nr] & (1 << nc)) != 0) {
				return true;
			}
		}
		return false;
	}

	private static void pick(int r, int c) {
		for (int i = 0; i < 5; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			isPlanted[nr] &= ~(1 << nc);
		}
	}

	private static void plant(int r, int c) {
		for (int i = 0; i < 5; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			isPlanted[nr] |= 1 << nc;
		}
	}

	private static int sum(int r, int c) {
		int s = 0;
		for (int i = 0; i < 5; i++) {
			s += G[r + dr[i]][c + dc[i]];
		}
		return s;
	}
}
