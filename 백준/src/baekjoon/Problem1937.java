package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1937
 */
public class Problem1937 {

	private static int[][] map;
	private static int max = Integer.MIN_VALUE;
	private static int N;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer st;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				bfs(new Node(r, c, 1, map[r][c]));
			}
		}

		System.out.println(max);
	}

	private static void bfs(Node n) {
		Queue<Node> queue = new LinkedList<>();
		boolean[][][] isVisited = new boolean[N][N][4];

		Arrays.fill(isVisited[n.row][n.col], true);
		queue.offer(n);
		int count = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			count = Math.max(count, cur.count);
			for (int i = 0; i < 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}

				if (isVisited[nr][nc][i] || map[nr][nc] <= cur.bamboo) {
					continue;
				}

				isVisited[nr][nc][i] = true;
				queue.add(new Node(nr, nc, cur.count + 1, map[nr][nc]));
			}
		}
		max = Math.max(count, max);
	}

	private static class Node {
		int row;
		int col;
		int count;
		int bamboo;

		public Node(int row, int col, int count, int bamboo) {
			this.row = row;
			this.col = col;
			this.count = count;
			this.bamboo = bamboo;
		}
	}
}
