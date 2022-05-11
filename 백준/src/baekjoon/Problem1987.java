package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1987
 */
public class Problem1987 {

	private static Set<Character> set;
	private static Character[][] map;
	private static int answer = Integer.MIN_VALUE;
	private static int R;
	private static int C;

	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new Character[R][C];
		set = new HashSet<>();

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		set.add(map[0][0]);
		dfs(0, 0, 0);

		System.out.println(answer + 1);
	}

	private static void dfs(int row, int col, int count) {

		if (canNotMove(row, col)) {
			answer = Math.max(answer, count);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (outOfBound(nr, nc)) {
				continue;
			}

			if (set.contains(map[nr][nc])) {
				continue;
			}

			Character element = map[nr][nc];
			set.add(element);
			dfs(nr, nc, count + 1);
			set.remove(element);
		}

	}

	private static boolean canNotMove(int row, int col) {

		boolean canNotMove = true;

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (outOfBound(nr, nc)) {
				continue;
			}

			if (set.contains(map[nr][nc])) {
				continue;
			}

			canNotMove = false;
			break;
		}
		return canNotMove;
	}

	private static boolean outOfBound(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= R || nc >= C;
	}
}
