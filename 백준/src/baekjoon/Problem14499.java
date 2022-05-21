package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14499
 */
public class Problem14499 {

	private static int R;
	private static int C;
	private static int[] dr = {0, 0, 0, -1, 1};
	private static int[] dc = {0, 1, -1, 0, 0};
	private static int[][] map;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		Dice dice = new Dice(r, c);
		while (K-- > 0) {
			int direction = Integer.parseInt(st.nextToken());
			dice.move(direction);
		}
		System.out.println(sb);
	}

	private static class Dice {
		int row;
		int col;

		/**
		 * N
		 * W	MN E
		 * MS
		 * S
		 */
		int N;
		int W;
		int MN;
		int E;
		int MS;
		int S;

		public Dice(int row, int col) {
			this.row = row;
			this.col = col;
			this.N = 0;
			this.W = 0;
			this.MN = 0;
			this.MS = 0;
			this.E = 0;
			this.S = 0;
		}

		public void move(int direction) {

			int nr = row + dr[direction];
			int nc = col + dc[direction];
			if (canNotMove(nr, nc)) {
				return;
			}

			this.row = nr;
			this.col = nc;
			/**
			 * 1 : 동
			 * 2 : 서
			 * 3 : 북
			 * 4 : 남
			 */
			switch (direction) {
				case 1:
					east();
					break;
				case 2:
					west();
					break;
				case 3:
					north();
					break;
				case 4:
					south();
					break;
			}

			check();
		}

		private void check() {
			sb.append(MN).append("\n");

			if (map[row][col] == 0) {
				map[row][col] = S;
				return;
			}
			S = map[row][col];
			map[row][col] = 0;

		}

		private boolean canNotMove(int nr, int nc) {
			return nr < 0 || nc < 0 || nr >= R || nc >= C;
		}

		private void south() {
			int tmp = this.S;
			this.S = this.MS;
			this.MS =this. MN;
			this.MN = this.N;
			this.N = tmp;
		}

		private void north() {
			int tmp = N;
			N = MN;
			MN = MS;
			MS = S;
			S = tmp;
		}

		private void west() {
			int tmp = S;
			S = W;
			W = MN;
			MN = E;
			E = tmp;
		}

		private void east() {
			int tmp = S;
			S = E;
			E = MN;
			MN = W;
			W = tmp;
		}
	}
}
