package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/3190
 */
public class Problem3190 {

	private static int N;
	private static int[][] map;
	private static Queue<Direction> directions;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		directions = new LinkedList<>();

		initializeMap(br);
		initializeDirections(br);

		int time = 0;
		Snake snake = new Snake();
		while (true) {
			time++;

			int curD = snake.direction;
			int nr = snake.head().row + dr[curD];
			int nc = snake.head().col + dc[curD];


			if (nr < 1 || nc < 1 || nr > N || nc > N) {
				break;
			}

			if (snake.position.size() != 1 && snake.position.contains(new Node(nr, nc))) {
				break;
			}

			snake.move();

			if (!directions.isEmpty() && directions.peek().time == time) {
				snake.changeDirection(directions.poll().direction);
			}

		}

		System.out.println(time);

	}

	private static void initializeDirections(BufferedReader br) throws IOException {
		StringTokenizer st;

		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			directions.add(new Direction(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 4;
		}
	}

	private static class Snake {
		List<Node> position = new LinkedList<>();
		int direction;

		public Snake() {
			this.position.add(new Node(1, 1));
			this.direction = 1;
		}

		public void add(int row, int col) {
			this.position.add(new Node(row, col));
		}

		public Node head() {
			return this.position.get(0);
		}

		public Node tail() {
			return this.position.get(position.size() - 1);
		}

		public void removeTail() {
			this.position.remove(position.size() - 1);
		}

		public void move() {
			int nr = head().row + dr[direction];
			int nc = head().col + dc[direction];
			position.add(0, new Node(nr, nc));

			if (map[nr][nc] != 4) {
				removeTail();
				return;
			}
			map[nr][nc] = 0;
		}
		public void changeDirection(String direction) {
			if (direction.equals("L")) {
				this.direction = this.direction == 0 ? 3 : this.direction - 1;
				return;
			}
			this.direction = this.direction == 3 ? 0 : this.direction + 1;
		}
	}

	private static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public boolean equals(Object obj) {
			Node node = (Node) obj;

			return this.row == node.row && this.col == node.col;
		}
	}

	private static class Direction {
		int time;
		String direction;

		public Direction(int time, String direction) {
			this.time = time;
			this.direction = direction;
		}

	}

}
