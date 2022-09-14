package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9079
 */
public class Problem9079 {

	private static int[][] map;
	private static int min = Integer.MAX_VALUE;
	private static boolean[][] checked;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (T-- > 0) {
			min = Integer.MAX_VALUE;
			map = new int[3][3];
			checked = new boolean[513][513];
			initialize(br);
			dfs(map, 0);

			if (min == Integer.MAX_VALUE) {
				min = -1;
			}
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int[][] m, int count) {
		int status = getStatus(m);

		if (count >= min) {
			return;
		}

		if (checked[status][count]) {
			return;
		}

		if (count >= 512) {
			return;
		}

		checked[status][count] = true;

		if (isRight(m)) {
			min = Math.min(min, count);
			return;
		}

		// row 뒤집기
		for (int r = 0; r < 3; r++) {
			int[][] clone = getClone(m);
			flipRow(clone, r);
			dfs(clone, count + 1);
		}

		// col 뒤집기
		for (int c = 0; c < 3; c++) {
			int[][] clone = getClone(m);
			flipCol(clone, c);
			dfs(clone, count + 1);
		}

		// 대각선 뒤집기
		for (int i = 0; i < 2; i++) {
			int[][] clone = getClone(m);
			flipDiagonal(clone, i);
			dfs(clone, count + 1);
		}
	}

	private static int[][] getClone(int[][] m) {
		int[][] clone = new int[3][3];
		for (int i = 0; i < m.length; i++) {
			System.arraycopy(m[i], 0, clone[i], 0, 3);
		}
		return clone;
	}

	private static boolean isRight(int[][] m) {
		int flag = m[0][0];
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (m[r][c] != flag) {
					return false;
				}
			}
		}
		return true;
	}

	private static void flipDiagonal(int[][] clone, int i) {
		if (i == 0) {
			flip(clone, 0, 0);
			flip(clone, 1, 1);
			flip(clone, 2, 2);
			return;
		}
		flip(clone, 0, 2);
		flip(clone, 1, 1);
		flip(clone, 2, 0);
	}

	private static void flipCol(int[][] clone, int c) {
		for (int r = 0; r < 3; r++) {
			flip(clone, r, c);
		}
	}

	private static void flipRow(int[][] clone, int r) {
		for (int c = 0; c < 3; c++) {
			flip(clone, r, c);
		}
	}

	private static void flip(int[][] clone, int r, int c) {
		clone[r][c] = clone[r][c] == 1 ? 0 : 1;
	}

	private static int getStatus(int[][] m) {
		int sum = 0;
		int cnt = 0;
		for (int r = 2; r >= 0; r--) {
			for (int c = 2; c >= 0; c--) {
				sum += m[r][c] * (int) Math.pow(2, cnt++);
			}
		}

		return sum;
	}

	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				String s = st.nextToken();
				if (s.equals("H")) {
					map[i][j] = 1;
					continue;
				}
				map[i][j] = 0;
			}
		}
	}
}
