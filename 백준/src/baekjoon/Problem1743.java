package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1743
 */
public class Problem1743 {

	private static int[][] map;
	private static boolean[][] isVisited;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};
	private static int R;
	private static int C;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		isVisited = new boolean[R][C];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = 1;
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (isVisited[r][c] || map[r][c] == 0) {
					continue;
				}
				int count = bfs(r, c);
				answer = Math.max(answer, count);
			}
		}
		System.out.println(answer);
	}

	private static int bfs(int r, int c) {
		int ret = 1;

		Queue<Node> q = new LinkedList<>();
		isVisited[r][c] = true;
		q.add(new Node(r, c));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int cr = cur.row;
			int cc = cur.col;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					continue;
				}

				if (isVisited[nr][nc] || map[nr][nc] == 0) {
					continue;
				}

				isVisited[nr][nc] = true;
				ret++;
				q.add(new Node(nr, nc));
			}
		}
		return ret;
	}

	private static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
