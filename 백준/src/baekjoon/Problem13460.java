package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/13460
 */
public class Problem13460 {

	public static final char HOLE = 'O';
	public static final boolean BLUE = false;
	public static final boolean RED = true;
	private static int R;
	private static int C;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		Marble blue = null;
		Marble red = null;
		for (int r = 0; r < R; r++) {
			char[] word = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				map[r][c] = word[c];

				if (map[r][c] == 'B') {
					blue = new Marble(r, c, BLUE);
					continue;
				}

				if (map[r][c] == 'R') {
					red = new Marble(r, c, RED);
				}
			}
		}

		dfs(map, blue, red, 0);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void dfs(char[][] map, Marble blue, Marble red, int depth) {

		if (!blue.end && red.end) {
			min = Math.min(min, depth);
			return;
		}

		if (depth == 10) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			Marble nb = new Marble(blue);
			Marble nr = new Marble(red);
			char[][] m = new char[R][C];
			for (int r = 0; r < R; r++) {
				m[r] = map[r].clone();
			}

			move(nb, nr, i, m);

			if (blue.end) {
				continue;
			}

			dfs(m, nb, nr, depth + 1);
		}
	}

	private static void move(Marble blue, Marble red, int direction, char[][] map) {
		// 움직이는 방향에 따라 순서가 다름
		// 위
		if (direction == 0 && blue.col == red.col) {
			if (blue.row < red.row) {
				blue.move(direction, map);
				red.move(direction, map);
			}

			red.move(direction, map);
			blue.move(direction, map);
			return;
		}
		// 왼쪽
		if (direction == 1 && blue.row == red.row) {
			if (blue.col < red.col) {
				blue.move(direction, map);
				red.move(direction, map);
				return;
			}

			red.move(direction, map);
			blue.move(direction, map);
			return;
		}
		// 아래
		if (direction == 2 && blue.col == red.col) {
			if (blue.row > red.row) {
				blue.move(direction, map);
				red.move(direction, map);
				return;
			}

			red.move(direction, map);
			blue.move(direction, map);
			return;
		}
		// 오른쪽
		if (direction == 3 && blue.row == red.row) {
			if (blue.col > red.col) {
				blue.move(direction, map);
				red.move(direction, map);
				return;
			}

			red.move(direction, map);
			blue.move(direction, map);
			return;
		}

		blue.move(direction, map);
		red.move(direction, map);
	}

	private static class Marble {
		public static final char SPACE = '.';
		int row;
		int col;
		boolean end;
		boolean color;

		public Marble(int r, int c, boolean color) {
			this.row = r;
			this.col = c;
			this.end = false;
			this.color = color;
		}

		public Marble(Marble marble) {
			this.row = marble.row;
			this.col = marble.col;
			this.end = marble.end;
			this.color = marble.color;
		}

		public void move(int direction, char[][] map) {

			map[row][col] = SPACE;

			switch (direction) {
				case 0:
					up(map);
					break;

				case 1:
					left(map);
					break;

				case 2:
					down(map);
					break;

				case 3:
					right(map);
					break;
			}

			if (map[row][col] != HOLE) {
				if (this.color == RED) {
					map[row][col] = 'R';
				} else {
					map[row][col] = 'B';
				}
			}
		}

		private void right(char[][] map) {
			int nc = col;
			for (int c = col + 1; c < C; c++) {
				if (map[row][c] == HOLE) {
					end = true;
					nc = c;
					break;
				}
				if (map[row][c] != SPACE) {
					break;
				}
				nc = c;
			}
			col = nc;
		}

		private void down(char[][] map) {
			int nr = row;
			for (int r = row + 1; r < R; r++) {
				if (map[r][col] == HOLE) {
					end = true;
					nr = r;
					break;
				}

				if (map[r][col] != SPACE) {
					break;
				}
				nr = r;
			}
			row = nr;
		}

		private void left(char[][] map) {
			int nc = col;
			for (int c = col - 1; c >= 0; c--) {
				if (map[row][c] == HOLE) {
					end = true;
					nc = c;
					break;
				}
				if (map[row][c] != SPACE) {
					break;
				}
				nc = c;
			}
			col = nc;
		}

		private void up(char[][] map) {
			int nr = row;
			for (int r = row - 1; r >= 0; r--) {
				if (map[r][col] == HOLE) {
					end = true;
					nr = r;
					break;
				}

				if (map[r][col] != SPACE) {
					break;
				}
				nr = r;
			}
			row = nr;
		}
	}
}
