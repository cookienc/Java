package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/4485
 */
public class Problem4485 {

	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};
	public static final int INF = 125 * 10;
	private static int[][] map;
	private static int[][] minusRupie;
	private static int N;

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 0;
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			initializeMap(br);

			bfs(0, 0);
			sb.append("Problem " + ++cnt + ": ").append(minusRupie[N - 1][N - 1]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void bfs(int row, int col) {
		PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.cost));
		minusRupie[row][col] = map[row][col];
		pq.add(new Position(row, col, map[row][col]));

		while (!pq.isEmpty()) {
			Position cur = pq.poll();
			int cr = cur.row;
			int cc = cur.col;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (outOfRange(nr, nc)) {
					continue;
				}

				if (minusRupie[nr][nc] <= minusRupie[cr][cc] + map[nr][nc]) {
					continue;
				}

				minusRupie[nr][nc] = minusRupie[cr][cc] + map[nr][nc];
				pq.add(new Position(nr, nc, minusRupie[nr][nc]));
			}
		}
	}

	private static boolean outOfRange(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= N || nc >= N;
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		map = new int[N][N];
		minusRupie = new int[N][N];
		for (int r = 0; r < N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				minusRupie[r][c] = INF;
			}
		}
	}

	private static class Position {
		int row;
		int col;
		int cost;

		public Position(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}
	}
}
