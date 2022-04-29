package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1937
 */
public class Problem1937 {

	private static int[][] map;
	private static int[][] distance;
	private static int max = Integer.MIN_VALUE;
	private static int N;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};
	private static int num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		distance = new int[N][N];

		StringTokenizer st;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				max = Math.max(max, dfs(r, c));
			}
		}
		System.out.println(max);
	}

	private static int dfs(int row, int col) {
		if (distance[row][col] != 0) {
			return distance[row][col];
		}

		distance[row][col] = 1;

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}

			if (map[row][col] >= map[nr][nc]) {
				continue;
			}

			distance[row][col] = Math.max(distance[row][col], dfs(nr, nc) + 1);
		}

		return distance[row][col];
	}
}
