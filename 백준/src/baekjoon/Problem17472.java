package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/17472
 */
public class Problem17472 {
	/**
	 * 1. 섬 색깔 서로 다르게 색칠
	 * 2. 다리
	 *     방향 유지 -> 파라미터로 전달 0 1 2 3 4
	 *     0이면 방향 설정 전 이므로 방향 설정
	 *     직선 끝에 섬이 있어야 함
	 *     길이가 1보다 큼
	 * 3. 한섬 에서 다른 섬으로 연결 가능한 방법 모두 구해서
	 *     최소한으로 모두 연결되도록 선택 -> 크루스칼
	 */

	private static int[][] map;
	private static boolean[][] isVisited;
	private static int[] parent;
	private static PriorityQueue<Bridge> pq;
	private static final int[] dr = {0, -1, 0, 1, 0};
	private static final int[] dc = {0,  0, -1, 0, 1};
	private static int R;
	private static int C;
	private static int color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		isVisited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0 || isVisited[r][c]) {
					continue;
				}
				colorIsland(r, c);
			}
		}

		int count = color;

		pq = new PriorityQueue<>(Comparator.comparingInt(b -> b.weight));
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0) {
					continue;
				}
				isVisited = new boolean[R][C];
				makeBridge(r, c);
			}
		}
		parent = new int[count + 1];
		for (int i = 0; i <= count; i++) {
			parent[i] = i;
		}
		int answer = Kruskal(count);

		for (int i = 2; i <= count; i++) {
			if (parent[i - 1] != parent[i]) {
				answer = -1;
				break;
			}
		}

		System.out.println(answer);
	}

	private static void makeBridge(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		isVisited[r][c] = true;
		int number = map[r][c];
		queue.add(new Node(r, c));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int tmp = map[node.row][node.col];
			map[node.row][node.col] = 9;
			map[node.row][node.col] = tmp;
			if (map[node.row][node.col] != number && map[node.row][node.col] != 0) {
				if (node.count - 1 < 2) {
					continue;
				}
				pq.add(new Bridge(number, map[node.row][node.col], node.count - 1));
				continue;
			}

			if (node.direction == 0) {
				for (int i = 1; i <= 4; i++) {
					int nr = node.row + dr[i];
					int nc = node.col + dc[i];

					if (isNotBoundary(nr, nc) || map[nr][nc] == number) {
						continue;
					}

					isVisited[nr][nc] = true;
					queue.add(new Node(nr, nc, i, node.count + 1));
				}
			} else {
				int nr = node.row + dr[node.direction];
				int nc = node.col + dc[node.direction];

				if (isNotBoundary(nr, nc) || map[nr][nc] == number) {
					continue;
				}

				isVisited[nr][nc] = true;
				queue.add(new Node(nr, nc, node.direction, node.count + 1));
			}
		}
	}

	private static void colorIsland(int r, int c) {

		color++;

		Queue<Node> queue = new LinkedList<>();

		isVisited[r][c] = true;
		map[r][c] = color;
		queue.add(new Node(r, c));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int i = 1; i <= 4; i++) {
				int nr = cur.row + dr[i];
				int nc = cur.col + dc[i];

				if (isNotMatch(nr, nc)) {
					continue;
				}

				isVisited[nr][nc] = true;
				map[nr][nc] = color;
				queue.add(new Node(nr, nc));
			}
		}
	}

	private static boolean isNotMatch(int nr, int nc) {
		return isNotBoundary(nr, nc) || isVisited[nr][nc] || map[nr][nc] == 0;
	}

	private static boolean isNotBoundary(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= R || nc >= C;
	}

	private static int getParent(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = getParent(parent[a]);
	}

	private static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static boolean isUnion(int a, int b) {
		a = getParent(a);
		b = getParent(b);

		return a == b;
	}
	private static int Kruskal(int size) {
		int count = 0;
		int sum = 0;
		while (!pq.isEmpty() && count != size - 1) {
			Bridge b = pq.poll();
			if (!isUnion(b.from, b.to)) {
				sum += b.weight;
				count++;
				union(b.from, b.to);
			}
		}

		for (int i = 1; i <= size; i++) {
			parent[i] = getParent(i);
		}
		return sum;
	}

	private static class Bridge {
		int from;
		int to;
		int weight;

		public Bridge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	private static class Node {
		int row;
		int col;
		int direction;
		int count;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
			this.direction = 0;
			this.count = 0;
		}

		public Node(int row, int col, int direction, int count) {
			this.row = row;
			this.col = col;
			this.direction = direction;
			this.count = count;
		}
	}
}
