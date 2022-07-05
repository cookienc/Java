package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16926
 */
public class Problem16926 {

	private static int R;
	private static int C;
	private static final int[] dr = {0, 1, 0, - 1};
	private static final int[] dc = {1, 0, -1, 0};
	private static int size;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());

		initializeArr(br, R, C);

		size = Math.min(R, C) / 2;
		while (count-- > 0) {
			countClockwise();
		}

		StringBuilder sb = new StringBuilder();
		for (int[] i : arr) {
			for (int value : i) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void countClockwise() {
		for (int i = 0; i < size; i++) {
			int r = i;
			int c = i;

			int value = arr[r][c];

			int direction = 0;// 방향 초기값 오른쪽

			while (direction < 4) {
				int nr = r + dr[direction];
				int nc = c + dc[direction];

				if (nr < i || nc < i || nr >= R - i || nc >= C - i) {
					direction++;
					continue;
				}

				arr[r][c] = arr[nr][nc];
				r = nr;
				c = nc;
			}

			arr[i + 1][i] = value;
		}
	}

	private static void initializeArr(BufferedReader br, int R, int C) throws IOException {
		StringTokenizer st;
		arr = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
