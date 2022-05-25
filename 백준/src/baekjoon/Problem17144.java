package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/17144
 */
public class Problem17144 {

	private static int R;
	private static int C;
	private static int T;
	private static int[][] dust;
	private static int[][] after;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = { 0, -1, 0, 1};
	private static Circulator machine;
	private static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		machine = new Circulator();
		initializeMap(br);

		while (T-- > 0) {
			diffusionDust();
			machine.operation();
		}

		System.out.println(sum);
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		StringTokenizer st;
		Node up = null;
		Node down = null;
		dust = new int[R][C];
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				dust[r][c] = Integer.parseInt(st.nextToken());

				if (dust[r][c] == -1) {
					if (up == null) {
						up = new Node(r, c);
						continue;
					}
					down = new Node(r, c);
					continue;
				}

				sum += dust[r][c];
			}
		}
		machine.setPosition(up, down);


	}

	private static void diffusionDust() {
		after = new int[R][C];
		after[machine.up.row][machine.up.col] = -1;
		after[machine.down.row][machine.down.col] = -1;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (dust[r][c] != 0 && dust[r][c] != -1) {
					int cur = dust[r][c];
					int diff = cur / 5;
					for (int i = 0; i < 4; i++) {
						int nr = r + dr[i];
						int nc = c + dc[i];

						if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
							continue;
						}

						if (dust[nr][nc] == -1) {
							continue;
						}

						after[nr][nc] += diff;
						cur -= diff;
					}
					after[r][c] += cur;
				}
			}
		}

		dust = after;
	}

	private static class Circulator {
		Node up;
		Node down;

		public Circulator() {
			up = null;
			down = null;
		}

		public void setPosition(Node up, Node down) {
			this.up = up;
			this.down = down;
		}

		public void operation() {
			upWind();
			downWind();
		}

		private void upWind() {
			int row = this.up.row;
			int col = this.up.col;

			//왼쪽위
			for (int r = row ; r > 0; r--) {
				if (r == row) {
					sum -= dust[r - 1][0];
					continue;
				}
				dust[r][0] = dust[r - 1][0];
			}

			//윗면
			for (int c = 0; c < C - 1; c++) {
				dust[0][c] = dust[0][c + 1];
			}

			//옆면
			for (int r = 0; r < row; r++) {
				dust[r][C - 1] = dust[r + 1][C - 1];
			}

			//아랫면
			for (int c = C - 1; c > 1; c--) {
				dust[row][c] = dust[row][c - 1];
			}

			dust[row][1] = 0;
		}

		private void downWind() {
			int row = this.down.row;
			int col = this.down.col;

			//왼쪽 아래
			for (int r = row ; r < R - 1; r++) {
				if (r == row) {
					sum -= dust[r + 1][0];
					continue;
				}
				dust[r][0] = dust[r + 1][0];
			}

			//아랫면
			for (int c = 0; c < C - 1; c++) {
				dust[R - 1][c] = dust[R - 1][c + 1];
			}

			//옆면
			for (int r = R - 1; r > row; r--) {
				dust[r][C - 1] = dust[r - 1][C - 1];
			}

			//윗면
			for (int c = C - 1; c > 1; c--) {
				dust[row][c] = dust[row][c - 1];
			}

			dust[row][1] = 0;
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
