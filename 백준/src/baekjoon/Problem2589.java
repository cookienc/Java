package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2589
 */
public class Problem2589 {

	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};

	private static int R;
	private static int C;

	private static boolean[][] map;
	private static boolean[][] isVisited;
	private static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new boolean[R][C];
		isVisited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				if (str.charAt(c) == 'W') {
					map[r][c] = false;
					continue;
				}
				map[r][c] = true;
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (!map[r][c]) {
					continue;
				}
				isVisited = new boolean[R][C];
				bfs(new Node(r, c, 0));
			}
		}

		System.out.println(answer);
	}

	private static void bfs(Node start) {
		Queue<Node> queue = new LinkedList<>();

		isVisited[start.row][start.col] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					continue;
				}

				if (isVisited[nr][nc] || !map[nr][nc]) {
					continue;
				}

				isVisited[nr][nc] = true;
				queue.add(new Node(nr, nc, cur.distance + 1));
			}

			answer = Math.max(answer, cur.distance);
		}
	}

	private static class Node {
		int row;
		int col;
		int distance;

		public Node(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
		}
	}
}
