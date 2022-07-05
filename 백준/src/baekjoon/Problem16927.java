package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16927
 */
public class Problem16927 {

	private static int[][] arr;
	private static int R;
	private static int C;
	private static final int[] dr = {0, 1, 0, -1};
	private static final int[] dc = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int rotate = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		initializeArr(br, R, C);

		int count = Math.min(R, C) / 2;

		int rL = R;
		int cL = C;
		for (int i = 0; i < count; i++) {
			int realRo = rotate % (2 * (rL + cL) - 4);
			counterclockwise(realRo, i);
			rL -= 2;
			cL -= 2;
		}

		StringBuilder sb = new StringBuilder();
		for (int[] array : arr) {
			for (int i : array) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void counterclockwise(int rotate, int start) {
		Queue<Integer> q = new LinkedList<>();

		int direction = 0;
		int r = start;
		int c = start;

		q.add((int) arr[r][c]);
		while (direction < 4) {
			int nr = r + dr[direction];
			int nc = c + dc[direction];

			if (nr < start || nc < start || nr >= R - start || nc >= C - start ||
					(nr == start && nc == start)) {
				direction++;
				continue;
			}

			q.add((int) arr[nr][nc]);
			r = nr;
			c = nc;
		}

		write(start, rotate, q);
	}

	private static void write(int start, int rotate, Queue<Integer> q) {

		while (rotate-- > 0) {
			q.add(q.poll());
		}

		int r = start;
		int c = start;

		arr[r][c] = (int) q.poll();

		int direction = 0;
		while (direction < 4) {
			int nr = r + dr[direction];
			int nc = c + dc[direction];

			if (nr < start || nc < start || nr >= R - start || nc >= C - start ||
					(nr == start && nc == start)) {
				direction++;
				continue;
			}

			if (nr == start && nc == start) {
				break;
			}

			arr[nr][nc] = (int) q.poll();
			r = nr;
			c = nc;
		}
	}

	private static void initializeArr(BufferedReader br, int R, int C) throws IOException {
		StringTokenizer st;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
