package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/15686
 */
public class Problem15686 {

	private static int N;
	private static int M;
	private static int min = Integer.MAX_VALUE;
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, -1, 0, 1};

	private static int[][] map;
	private static boolean[][] isVisited;
	private static boolean[] isChoose;
	private static Node[] nodes;
	private static List<Node> home;
	private static List<Node> chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		chicken = new ArrayList<>();
		map = new int[N][N];
		isVisited = new boolean[N][N];

		initialize(br);

		isChoose = new boolean[chicken.size()];
		nodes = new Node[M];

		choiceChicken(0, 0);

		System.out.println(min);
	}

	private static void choiceChicken(int depth, int start) {

		if (depth == M) {
			int[][] cal = bfs(nodes);
			min = Math.min(min, findDistance(cal));
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			if (isChoose[i]) {
				continue;
			}

			isChoose[i] = true;
			nodes[depth] = chicken.get(i);
			choiceChicken(depth + 1, i + 1);
			isChoose[i] = false;
		}
	}

	private static int findDistance(int[][] cal) {
		int sum = 0;
		for (Node n : home) {
			sum += cal[n.row][n.col];
		}
		return sum;
	}

	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					home.add(new Node(i, j));
				}

				if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}

			}
		}
	}

	private static int[][] bfs(Node[] nodes) {
		int[][] tmp = new int[N][N];
		isVisited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(tmp[i], 999);
		}

		Queue<Node> queue = new LinkedList<>();
		for (Node c : nodes) {
			isVisited[c.row][c.col] = true;
			queue.add(c);
		}

		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextR = poll.row + dr[i];
				int nextC = poll.col + dc[i];

				if (nextC < 0 || nextR < 0 || nextC >= N || nextR >= N) {
					continue;
				}

				if (isVisited[nextR][nextC]) {
					continue;
				}

				isVisited[nextR][nextC] = true;
				tmp[nextR][nextC] = Math.min(tmp[nextR][nextC], poll.distance + 1);
				queue.add(new Node(nextR, nextC, poll.distance + 1));
			}
		}
		return tmp;
	}

	private static class Node {
		int row;
		int col;
		int distance;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
			this.distance = 0;
		}

		public Node(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
		}
	}
}
