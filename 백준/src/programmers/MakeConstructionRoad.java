package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/67259
 */
public class MakeConstructionRoad {
	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};
	private static int[][][] cost;
	private static int[][] map;
	private static int N;

	public class Solution {
		public int solution(int[][] board) {
			N = board.length;
			map = board;

			cost = new int[N][N][4];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					Arrays.fill(cost[r][c], Integer.MAX_VALUE);
				}
			}

			bfs();

			return Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
		}

		private void bfs() {
			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(0, 0, 0, 1));
			queue.add(new Node(0, 0, 0, 3));

			while (!queue.isEmpty()) {
				Node cur = queue.poll();

				for (int k = 0; k < 4; k++) {
					int nr = cur.row + dr[k];
					int nc = cur.col + dc[k];
					int c = cur.cost + (cur.direction == k ? 100 : 600);

					if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == 1 || cost[nr][nc][k] <= c) {
						continue;
					}
					cost[nr][nc][k] = c;
					queue.add(new Node(nr, nc, c, k));
				}
			}
		}
	}

	private static class Node {
		int row;
		int col;
		int cost;
		int direction;

		public Node(int row, int col, int cost, int direction) {
			this.row = row;
			this.col = col;
			this.cost = cost;
			this.direction = direction;
		}
	}
}
