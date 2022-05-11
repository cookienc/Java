package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1987
 */
public class Problem1987 {

	private static int[][] map;
	private static int[][] visited;
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

		map = new int[R][C];
		visited = new int[R][C];

		for (int r = 0; r < R; r++) {
			char[] chars = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = chars[c] - 'A';
			}
		}

		dfs(0, 0, 1 << map[0][0], 1);

		System.out.println(answer);
	}

	private static void dfs(int row, int col, int bit, int count) {

		if (visited[row][col] == bit) {
			return;
		}

		visited[row][col] = bit;
		answer = Math.max(answer, count);

		for (int i = 0; i < 4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];

			if (outOfBound(nr, nc)) {
				continue;
			}

			if ((bit & 1 << map[nr][nc]) != 0) {
				continue;
			}

			dfs(nr, nc, bit | 1 << map[nr][nc], count + 1);
		}
	}

	private static boolean outOfBound(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= R || nc >= C;
	}
}
