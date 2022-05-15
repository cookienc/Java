package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14503
 */
public class Problem14503 {

	private static int R;
	private static int C;

	private static int[][] map;
	private static int[][] isVisited;
	private static Robot robot;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};

	private static int time = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		isVisited = new int[R][C];

		st = new StringTokenizer(br.readLine());
		robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
				, Integer.parseInt(st.nextToken()), 0);
		isVisited[robot.row][robot.col] = 1;

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					isVisited[r][c] = -1;
				}
			}
		}

		while (true) {
			int nextDirection = robot.rotate();
			int nr = robot.row + dr[nextDirection];
			int nc = robot.col + dc[nextDirection];

			if (robot.rotate > 4) {
				robot.rotateRight();
				if (robot.behindIsWall()) {
					break;
				}
				robot.back();
				continue;
			}

			if (map[nr][nc] != 0 || isVisited[nr][nc] != 0) {
				continue;
			}

			time++;
			isVisited[nr][nc] = time;
			robot.move(nr, nc, nextDirection);
		}

		System.out.println(time);
	}

	private static class Robot {
		int row;
		int col;
		int direction;
		int rotate;

		public Robot(int row, int col, int direction, int rotate) {
			this.row = row;
			this.col = col;
			this.direction = direction;
			this.rotate = rotate;
		}

		public int rotate() {
			this.rotate += 1;
			return this.direction = this.direction == 0? 3 : this.direction - 1;
		}

		public int rotateRight() {
			return this.direction = this.direction == 3? 0 : this.direction + 1;
		}

		public void move(int row, int col, int direction) {
			this.row = row;
			this.col = col;
			this.direction = direction;
			this.rotate = 0;
		}
		public void back() {
			int d = getBehind();
			int nr = this.row + dr[d];
			int nc = this.col + dc[d];

			this.move(nr, nc, this.direction);
		}

		public boolean behindIsWall() {
			int d = getBehind();
			int nr = this.row + dr[d];
			int nc = this.col + dc[d];

			if (map[nr][nc] == 1) {
				return true;
			}

			return false;
		}

		private int getBehind() {
			return (this.direction + 2) % 4;
		}
	}
}
