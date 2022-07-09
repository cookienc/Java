package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/17070
 */
public class Problem17070 {
	private static final int[][] dr = {
			{0, 1}, // 가로 0
			{1, 1}, // 세로 1
			{0, 1, 1} // 대각선 2
	};

	private static final int[][] dc = {
			{1, 1}, // 가로 0 -> 가로 0, 대각선 1
			{0, 1}, // 세로 1 -> 세로 0, 대각선 1
			{1, 0, 1} // 대각선 2 -> 가로 0, 세로 1, 대각선 2
	};

	private static int N;
	private static int[][] map;
	private static boolean[][][] isVisited;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		initializeMap(br);

		isVisited = new boolean[N][N][3];
		bfs(0, 1, 0);

		System.out.println(answer);
	}

	private static void bfs(int r, int c, int type) {
		if (r == N - 1 && c == N - 1) {
			answer++;
			return;
		}

		for (int i = 0; i < dr[type].length; i++) {
			int nr = r + dr[type][i];
			int nc = c + dc[type][i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}

			if (map[nr][nc] == 1) {
				continue;
			}

			if ((nr - r == nc - c) && (map[nr - 1][nc] == 1 || map[nr][nc - 1] == 1)) {
				continue;
			}

			if (type != 2) {
				if (i == 0) {
					bfs(nr, nc, type);
					continue;
				} else {
					bfs(nr, nc, 2);
					continue;
				}
			}

			if (i == 0) {
				bfs(nr, nc, 0);
				continue;
			}

			if (i == 1) {
				bfs(nr, nc, 1);
				continue;
			}

			bfs(nr, nc, 2);
		}
	}

	private static void initializeMap(BufferedReader br) throws IOException {
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	private static class Node {
		int row;
		int col;
		int type;

		public Node(int row, int col, int type) {
			this.row = row;
			this.col = col;
			this.type = type;
		}
	}
}
