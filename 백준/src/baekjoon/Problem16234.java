package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/16234
 */
public class Problem16234 {

	private static int N;
	private static int L;
	private static int R;
	private static int[][] map;
	private static boolean[][] isUnion;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		boolean end = false;
		while (!end) {
			isUnion = new boolean[N][N];
			count++;
			int search = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (isUnion[r][c]) {
						continue;
					}
					search++;
					bfs(r, c);
				}
			}

			if (search == N * N) {
				end = true;
			}
		}

		System.out.println(count - 1);
	}

	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		List<Node> member = new ArrayList<>();

		member.add(new Node(r, c));
		isUnion[r][c] = true;
		queue.add(new Node(r, c));

		int sum = map[r][c];
		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
					continue;
				}

				if (isUnion[nr][nc]) {
					continue;
				}
				int diff = Math.abs(map[nr][nc] - map[cur.row][cur.col]);
				if (diff < L || diff > R) {
					continue;
				}

				isUnion[nr][nc] = true;
				member.add(new Node(nr, nc));
				queue.add(new Node(nr, nc));
				sum += map[nr][nc];
			}
		}

		int after = sum / member.size();

		for (Node node : member) {
			map[node.row][node.col] = after;
		}
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
