package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/4963
 *
 * 구현목록:
 * 		1. 입력 받기
 *		2. bfs 알고리즘 만들기
 *		3. 출력 하기
 * 핵심:
 * 		dx, dy 배열 대각선 요소 추가
 */
public class Problem4963 {

	private static int w;
	private static int h;
	private static int[] dx = {1, -1, 0, 0, 1, -1, 1 , -1};
	private static int[] dy = {0, 0, 1, -1, 1, 1, -1 , -1};

	private static int[][] map;
	private static boolean[][] isVisited;
	private static int countIsland;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		StringBuilder stringBuilder = new StringBuilder();

		while (true) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			w =Integer.parseInt(stringTokenizer.nextToken());
			h =Integer.parseInt(stringTokenizer.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			countIsland = 0;
			map = new int[h + 1][w + 1];
			isVisited = new boolean[h + 1][w + 1];

			for (int i = 1; i <= h; i++) {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
				for (int j = 1; j <= w; j++) {
					map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}

			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (!isVisited[i][j] && (map[i][j] == 1)) {
						countIsland++;
						bfs(i, j);
					}
				}
			}
			stringBuilder.append(countIsland)
					.append("\n");
		}

		System.out.println(stringBuilder);
	}

	private static void bfs(int i, int j) {

		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[]{i, j});
		isVisited[i][j] = true;

		while (!queue.isEmpty()) {
			int currentRow = queue.peek()[0];
			int currentColumn = queue.peek()[1];

			queue.poll();

			for (int k = 0; k < 8; k++) {
				int nextRow = currentRow + dx[k];
				int nextColumn = currentColumn + dy[k];

				if ((nextRow > 0 && nextRow <= h) && (nextColumn > 0 && nextColumn <= w)) {
					if ((map[nextRow][nextColumn] == 1) && !isVisited[nextRow][nextColumn]) {
						queue.add(new int[]{nextRow, nextColumn});
						isVisited[nextRow][nextColumn] = true;
					}
				}
			}
		}
	}
}

