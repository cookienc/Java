package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2206
 */
public class Problem2206 {
	private static int R;
	private static int C;

	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};
	private static int[][] map;
	private static boolean[][][] isVisited;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		initializeMap(br);

		isVisited = new boolean[R][C][2];
		bfs(0, 0);

		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	private static void bfs(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
		isVisited[r][c][0] = true;
		isVisited[r][c][1] = true;
		pq.offer(new Node(r, c, 1));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.row == R - 1 && cur.col == C - 1) {
				min = Math.min(cur.distance, min);
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					continue;
				}

				if ((cur.canBreak && isVisited[nr][nc][0]) || (!cur.canBreak && isVisited[nr][nc][1])) {
					continue;
				}

				if (map[nr][nc] == 1 && !cur.canBreak) {
					continue;
				}

				if (map[nr][nc] == 1) {
					isVisited[nr][nc][1] = true;
					pq.add(new Node(nr, nc, cur.distance + 1, false));
					continue;
				}

				if (cur.canBreak) {
					isVisited[nr][nc][0] = true;
				} else {
					isVisited[nr][nc][1] = true;
				}
				pq.add(new Node(nr, nc, cur.distance + 1, cur.canBreak));
			}
		}
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		for (int r = 0; r < R; r++) {
			char[] chars = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = chars[c] - '0';
			}
		}
	}

	private static class Node {
		int row;
		int col;
		int distance;
		boolean canBreak;

		public Node(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
			this.canBreak = true;
		}

		public Node(int row, int col, int distance, boolean canBreak) {
			this.row = row;
			this.col = col;
			this.distance = distance;
			this.canBreak = canBreak;
		}
	}
}
