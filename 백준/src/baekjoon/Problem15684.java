package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15684
 */
public class Problem15684 {

	private static int[][] ladder;

	private static int answer = Integer.MAX_VALUE;
	private static final boolean LEFT = true;
	private static final boolean RIGHT = false;

	private static int C;
	private static int M;
	private static int R;

	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		ladder = new int[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			addLadder(row, col);
		}

		dfs(1, 0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}

	private static void dfs(int row, int depth) {
		if (depth > R || depth > 3 || depth >= answer) {
			return;
		}

		boolean isMovable = true;
		for (int i = 1; i <= C; i++) {
			if (!move(i)) {
				isMovable = false;
				break;
			}
		}

		if (isMovable) {
			answer = Math.min(depth, answer);
			return;
		}

		for (int r = row; r <= R; r++) {
			for (int c = 1; c <= C - 1; c++) {
				if (ladder[r][c] == 0 && ladder[r][c + 1] == 0) {
					addLadder(r, c);
					dfs(r, depth + 1);
					removeLadder(r, c);
				}
			}
		}

	}

	private static boolean move(int col) {

		int origin = col;
		for (int row = 1; row <= R; row++) {
			if (ladder[row][col] == 0) {
				continue;
			}

			if (ladder[row][col] == 2) {
				col--;
				continue;
			}
			col++;
		}

		if (origin == col) {
			return true;
		}
		return false;
	}

	private static void addLadder(int row, int col) {
		ladder[row][col] = 1;
		ladder[row][col + 1] = 2;
	}

	private static void removeLadder(int row, int col) {
		ladder[row][col] = 0;
		ladder[row][col + 1] = 0;
	}
}
