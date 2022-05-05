package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/17136
 */
public class Problem17136 {

	private static int[] paper = {0, 5, 5, 5, 5, 5};
	private static boolean[][] map = new boolean[10][10];
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int r = 0; r < 10; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 10; c++) {
				if (Integer.parseInt(st.nextToken()) == 0) {
					continue;
				}
				map[r][c] = true;
			}
		}

		dfs(0, 0, 0);
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	private static void dfs(int row, int col, int cnt) {

		if (row == 9 && col == 10) {
			min = Math.min(cnt, min);
			return;
		}

		if (cnt >= min) {
			return;
		}

		if (col > 9) {
			dfs(row + 1, 0, cnt);
			return;
		}

		if (map[row][col]) {
			for (int i = 5; i >= 1; i--) {
				if (canAttach(row, col, i) && paper[i] > 0) {
					paper[i]--;
					attach(row, col, i);
					dfs(row, col + 1, cnt + 1);
					paper[i]++;
					detach(row, col, i);
				}
			}
		} else {
			dfs(row, col + 1, cnt);
		}
	}

	private static void attach(int row, int col, int size) {
		for (int r = row; r < row + size; r++) {
			for (int c = col; c < col + size; c++) {
				map[r][c] = false;
			}
		}
	}
	private static void detach(int row, int col, int size) {
		for (int r = row; r < row + size; r++) {
			for (int c = col; c < col + size; c++) {
				map[r][c] = true;
			}
		}
	}

	private static boolean canAttach(int row, int col, int size) {
		for (int r = row; r < row + size; r++) {
			for (int c = col; c < col + size; c++) {
				if (r < 0 || c < 0 || r >= 10 || c >= 10) {
					return false;
				}

				if (!map[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

}