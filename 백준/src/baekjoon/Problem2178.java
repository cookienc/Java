package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2178
 * 알고리즘: bfs(토마토 문제(Problem7576와 비슷)
 */
public class Problem2178 {

	private static int[][] map;
	private static Queue<int[]> queue;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int m;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[n][m];
		queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String line = bufferedReader.readLine();
			for (int j = 0; j < m; j++) {
				int num = line.charAt(j) - '0';

				map[i][j] = num;
			}
		}

		bfs(0, 0);

		System.out.println(map[n - 1][m - 1]);
	}

	private static void bfs(int row, int column) {

		queue.add(new int[]{row, column});

		while (!queue.isEmpty()) {
			int currentRow = queue.peek()[0];
			int currentColumn = queue.peek()[1];
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = currentRow + dy[i];
				int nextColumn = currentColumn + dx[i];

				if (nextColumn >= 0 && nextColumn < m && nextRow >= 0 && nextRow < n) {
					if (map[nextRow][nextColumn] == 1) {
						queue.add(new int[]{nextRow, nextColumn});
						map[nextRow][nextColumn] = map[currentRow][currentColumn] + 1;
					}
				}
			}
		}
	}
}
