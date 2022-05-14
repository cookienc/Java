package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2573
 */
public class Problem2573 {

	private static int[][] iceberg;
	private static boolean[][] isZero;
	private static boolean[][] isVisited;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, -1, 0, 1};

	private static int R;
	private static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		iceberg = new int[R][C];

		initializeIceberg(br, R, C);

		isVisited = new boolean[R][C];

		int time = 0;
		int answer = 0;
		while (true) {

			int cnt = checkIceberg();
			if (cnt >= 2) {
				answer = time;
				break;
			} else if (cnt == 0) {
				break;
			}
			time++;

			isZero = new boolean[R][C];

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (iceberg[r][c] != 0 || isZero[r][c]) {
						continue;
					}
					bfs(r, c);
				}
			}

		}

		System.out.println(answer);
	}

	private static int checkIceberg() {

		isVisited = new boolean[R][C];
		int cnt = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (isVisited[r][c] || iceberg[r][c] == 0) {
					continue;
				}
				check(r, c);
				cnt++;
			}
		}

		return cnt;
	}

	private static void check(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		isVisited[r][c] = true;
		queue.add(new Node(r, c));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || isVisited[nr][nc]) {
					continue;
				}

				if (iceberg[nr][nc] == 0) {
					continue;
				}

				isVisited[nr][nc] = true;
				queue.add(new Node(nr, nc));
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		isZero[r][c] = true;
		queue.add(new Node(r, c));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || isZero[nr][nc]) {
					continue;
				}

				if (iceberg[nr][nc] != 0) {
					iceberg[nr][nc] -= 1;
					if (iceberg[nr][nc] == 0) {
						isZero[nr][nc] = true;
					}
					continue;
				}

				isZero[nr][nc] = true;
				queue.add(new Node(nr, nc));
			}
		}
	}

	private static void initializeIceberg(BufferedReader br, int R, int C) throws IOException {
		StringTokenizer st;
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				iceberg[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
