package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1261
 */
public class Problem1261 {

	private static int R;
	private static int C;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};

	private static int[][] map;
	private static boolean[][] isVisited;
	private static int min = Integer.MAX_VALUE;

	private static int SIZE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		SIZE = R + C - 1;
		initializeMap(br);

		isVisited = new boolean[R][C];
		bfs(new Node(0, 0, 0));

		System.out.println(min);
	}

	private static void bfs(Node n) {

		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);
		isVisited[n.row][n.col] = true;
		queue.add(n);

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.row == R - 1 && cur.col == C - 1) {
				min = cur.count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || isVisited[nr][nc]) {
					continue;
				}

				isVisited[nr][nc] = true;
				if (map[nr][nc] == 0) {
					queue.add(new Node(nr, nc, cur.count));
				} else {
					queue.add(new Node(nr, nc, cur.count + 1));
				}
			}
		}
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
	}

	private static class Node {
		int row;
		int col;
		int count;

		public Node(int row, int col, int count) {
			this.row = row;
			this.col = col;
			this.count = count;
		}
	}
}
