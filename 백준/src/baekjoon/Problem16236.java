package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16236
 */
public class Problem16236 {

	private static int[][] map;
	private static boolean[][] isVisited;
	private static Shark shark;
	private static int[] dy = {-1, 1, 0, 0};
	private static int[] dx = {0, 0, -1, 1};
	private static int N;
	private static int result = 0;
	private static PriorityQueue<Fish> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		isVisited = new boolean[N][N];

		initializeMap(br, N);

		pq = new PriorityQueue<>((f1, f2) -> {
			if (f1.distance == f2.distance) {
				if (f1.y == f2.y) {
					return f1.x - f2.x;
				} else {
					return f1.y - f2.y;
				}
			} else {
				return f1.distance - f2.distance;
			}
		});

		while (true) {
			bfs(shark);
			//먹이 찾기
			if (!pq.isEmpty()) {
				Fish fish = pq.poll();
				shark.eat(fish);
				map[fish.y][fish.x] = 0;
				pq.clear();

				isVisited = new boolean[N][N];
				isVisited[shark.y][shark.x] = true;
				continue;
			}
			break;
		}

		System.out.println(result);
	}

	private static void bfs(Shark shark) {
		Queue<Shark> queue = new LinkedList<>();
		isVisited[shark.y][shark.x] = true;
		queue.add(shark);
		int tmp = 0;

		while (!queue.isEmpty()) {
			Shark babyShark = queue.poll();
			int curY = babyShark.y;
			int curX = babyShark.x;
			//이동
			for (int i = 0; i < 4; i++) {
				int nextY = curY + dy[i];
				int nextX = curX + dx[i];

				if (isNotRange(nextY, nextX) || isVisited[nextY][nextX] ||
						cantEat(babyShark, nextY, nextX)) {
					continue;
				}

				isVisited[nextY][nextX] = true;

				if (map[nextY][nextX] < babyShark.size && map[nextY][nextX] != 0) {
					pq.add(new Fish(nextY, nextX, babyShark.distance + 1));
				}

				queue.add(new Shark(nextY, nextX, babyShark.size,
						babyShark.distance + 1, babyShark.eatCount));
			}
		}
	}

	private static boolean cantEat(Shark babyShark, int nextY, int nextX) {
		return map[nextY][nextX] > babyShark.size;
	}

	private static boolean isNotRange(int nextY, int nextX) {
		return nextX < 0 || nextY < 0 || nextX >= N || nextY >= N;
	}

	private static void initializeMap(BufferedReader br, int N) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					map[i][j] = 0;
					shark = new Shark(i, j, 2, 0, 0);
				}
			}
		}
	}

	private static class Fish {
		int y;
		int x;
		int distance;

		public Fish(int y, int x, int distance) {
			this.y = y;
			this.x = x;
			this.distance = distance;
		}
	}

	private static class Shark extends Fish {
		int size;

		int eatCount;

		public Shark(int y, int x, int size, int distance, int eatCount) {
			super(y, x, distance);
			this.size = size;
			this.eatCount = eatCount;
		}

		public void eat(Fish fish) {
			this.eatCount++;
			if (this.eatCount == this.size) {
				this.size++;
				this.eatCount = 0;
			}
			move(fish);
		}

		private void move(Fish fish) {
			this.y = fish.y;
			this.x = fish.x;
			result += fish.distance;
			this.distance = 0;
		}
	}
}
