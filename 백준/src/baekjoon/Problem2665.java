package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2665
 */
public class Problem2665 {

	private static int N;
	private static int[][] map;
	private static int[][] wall;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		initializeMap(br);

		bfs(new Node(0, 0, 0));

		System.out.println(wall[N - 1][N - 1]);
	}

	private static void bfs(Node node) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.wall));

		wall[0][0] = 0;
		pq.offer(node);

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int cr = cur.row;
			int cc = cur.col;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (outOfRange(nr, nc)) {
					continue;
				}

				if (cur.wall < wall[nr][nc]) {
					wall[nr][nc] = cur.wall;

					if (map[nr][nc] == 0) {
						pq.add(new Node(nr, nc, cur.wall + 1));
						continue;
					}

					pq.add(new Node(nr, nc, cur.wall));
				}
			}
		}
	}

	private static boolean outOfRange(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= N || nc >= N;
	}

	private static void initializeMap(BufferedReader br) throws IOException {

		int zero = 0;

		map = new int[N][N];
		wall = new int[N][N];

		for (int r = 0; r < N; r++) {
			char[] nums = br.readLine().toCharArray();
			for (int c = 0; c < N; c++) {
				map[r][c] = nums[c] - '0';
				if (map[r][c] == 0) {
					zero++;
				}
			}
		}

		for (int r = 0; r < N; r++) {
			Arrays.fill(wall[r], zero);
		}
	}

	private static class Node {
		int row;
		int col;
		int wall;

		public Node(int row, int col, int wall) {
			this.row = row;
			this.col = col;
			this.wall = wall;
		}
	}
}
