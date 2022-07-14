package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/17086
 */
public class Problem17086 {

	private static int R;
	private static int C;
	private static int[][] map;
	private static boolean[][] isVisited;

	private static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	private static final int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

	private static Queue<Node> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		q = new LinkedList<>();
		initializeMap(br);

		System.out.println(bfs());
	}

	private static int bfs() {
		int answer = 0;

		while (!q.isEmpty()) {
			PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

			isVisited = new boolean[R][C];
			Node shark = q.poll();
			pq.add(shark);
			isVisited[shark.row][shark.col] = true;

			while (!pq.isEmpty()) {
				boolean isEnd = false;
				Node cur = pq.poll();
				int cr = cur.row;
				int cc = cur.col;

				for (int i = 0; i < 8; i++) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
						continue;
					}

					if (isVisited[nr][nc]) {
						continue;
					}

					if (map[nr][nc] == 1) {
						answer = Math.max(answer, cur.distance + 1);
						isEnd = true;
						break;
					}

					isVisited[nr][nc] = true;
					pq.add(new Node(nr, nc, cur.distance + 1));
				}

				if (isEnd) {
					break;
				}
			}
		}
		return answer;
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		StringTokenizer st;
		map = new int[R][C];
		isVisited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

				if (map[r][c] == 0) {
					q.add(new Node(r, c, 0));
				}
			}
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
