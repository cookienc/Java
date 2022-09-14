package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/21610
 */
public class Problem21610 {

	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] isVisited;
	private static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			q = new LinkedList<>();
			makeCloud(i, q);
			q = moveCloud(q, d, s);

			isVisited = new boolean[N][N];
			rainAndBug(q);
		}

		makeCloud(1, q);

		int sum = 0;
		for (int[] water : map) {
			for (int w : water) {
				sum += w;
			}
		}
		System.out.println(sum);
	}

	private static void rainAndBug(Queue<Node> q) {
		Queue<Node> tmp = new LinkedList<>();

		while (!q.isEmpty()) {
			Node cloud = q.poll();
			int r = cloud.row;
			int c = cloud.col;

			isVisited[r][c] = true;
			map[r][c] += 1;
			tmp.add(new Node(r, c));
		}

		while (!tmp.isEmpty()) {
			Node cloud = tmp.poll();
			int r = cloud.row;
			int c = cloud.col;

			map[r][c] += bug(r, c);
		}
	}

	private static int bug(int r, int c) {
		int cnt = 0;

		if (check(r - 1, c - 1)) {
			cnt++;
		}
		if (check(r + 1, c - 1)) {
			cnt++;
		}
		if (check(r - 1, c + 1)) {
			cnt++;
		}
		if (check(r + 1, c + 1)) {
			cnt++;
		}

		return cnt;
	}

	private static boolean check(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < N) && map[r][c] >= 1;
	}

	private static Queue<Node> moveCloud(Queue<Node> q, int d, int s) {
		Queue<Node> move = new LinkedList<>();
		while (!q.isEmpty()) {
			Node cloud = q.poll();
			int nr = (cloud.row + dr[d] * (s % N) + N) % N;
			int nc = (cloud.col + dc[d] * (s % N) + N) % N;
			move.add(new Node(nr, nc));
		}
		return move;
	}

	private static void makeCloud(int i, Queue<Node> q) {
		if (i == 0) {
			q.add(new Node(N - 1, 0));
			q.add(new Node(N - 1, 1));
			q.add(new Node(N - 2, 0));
			q.add(new Node(N - 2, 1));
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (!isVisited[r][c] && map[r][c] >= 2) {
					q.add(new Node(r, c));
					map[r][c] -= 2;
				}
			}
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
