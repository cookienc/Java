package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2615
 */
public class Problem2615 {
	private static int[][] board;
	private static int[] isVisited;
	private static int[] dr = {-1, 0, 1, 1};
	private static int[] dc = {1, 1, 1, 0};
	private static int[] rdr = {1, 0, -1, -1};
	private static int[] rdc = {-1, -1, -1, 0};
	private static boolean end;

	public static void main(String[] args) throws IOException {
		board = new int[19][19];
		isVisited = new int[19];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int r = 0; r < 19; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 19; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < 19; r++) {
			for (int c = 0; c < 19; c++) {
				if ((isVisited[r] & 1 << c) != 0 || board[r][c] == 0) {
					continue;
				}

				for (int d = 0; d < 4; d++) {
					end = false;
					dfs(r, c, d, board[r][c], 1);

					if (end) {
						int nr = r + rdr[d];
						int nc = c + rdc[d];

						if (!(nr < 0 || nc < 0 || nr >= 19 || nc >= 19)) {
							if (board[nr][nc] == board[r][c]) {
								continue;
							}
						}

						System.out.println(board[r][c]);
						System.out.println((r + 1) + " " + (c + 1));
						return;
					}
				}
			}
		}
		System.out.println(0);

	}

	private static void dfs(int r, int c, int distance, int color, int count) {
		if (count >= 6) {
			return;
		}

		if (count == 5) {
			int nr = r + dr[distance];
			int nc = c + dc[distance];

			if (!(nr < 0 || nc < 0 || nr >= 19 || nc >= 19)) {
				if (board[nr][nc] == color) {
					return;
				}
			}

			end = true;
			return;
		}

		int nr = r + dr[distance];
		int nc = c + dc[distance];

		if (nr < 0 || nc < 0 || nr >= 19 || nc >= 19) {
			return;
		}

		if (board[nr][nc] != color) {
			return;
		}

		if ((isVisited[r] & 1 << c) != 0) {
			return;
		}
		isVisited[r] = isVisited[r] | 1 << c;
		dfs(nr, nc, distance, color, count + 1);
		isVisited[r] = isVisited[r] & ~(1 << c);
	}
}

