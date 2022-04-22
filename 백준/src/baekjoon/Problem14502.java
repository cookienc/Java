package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14502
 */
public class Problem14502 {

	private static int row;
	private static int col;
	private static int max = Integer.MIN_VALUE;
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());

		int[][] map = new int[row][col];

		for (int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		makeWall(map, 0);
		System.out.println(max);
	}

	private static void makeWall(int[][] origin, int cnt) {

		if (cnt == 3) {
			bfs(origin);
			return;
		}

		int[][] map = new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				map[r][c] = origin[r][c];
			}
		}

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (map[r][c] != 0) {
					continue;
				}
				map[r][c] = 1;
				makeWall(map, cnt + 1);
				map[r][c] = 0;
			}
		}
	}

	private static void bfs(int[][] origin) {

		Queue<int[]> queue = new LinkedList<>();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (origin[r][c] == 2) {
					queue.add(new int[]{r, c});
				}
			}
		}

		int[][] map = new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				map[r][c] = origin[r][c];
			}
		}

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextR = poll[0] + dr[i];
				int nextC = poll[1] + dc[i];

				if (nextR < 0 || nextC < 0 || nextR >= row || nextC >= col) {
					continue;
				}

				if (map[nextR][nextC] != 0) {
					continue;
				}
				map[nextR][nextC] = 2;
				queue.add(new int[]{nextR, nextC});
			}
		}

		int count = 0;
		for (int[] i : map) {
			for (int j : i) {
				if (j == 0) {
					count++;
				}
			}
		}
		max = Math.max(count, max);
	}
}