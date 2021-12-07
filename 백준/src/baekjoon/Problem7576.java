package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/7576
 * 구현목록 :
 * 			1. 입력
 * 			2. bfs 알고리즘
 * 			3. 예외처리 - 모두 다 익지 못하는 경우 -1 출력 -> 알고리즘을 마치고 토마토가 0일 때
 * 					- 1 입력이 두개 이상이면??
 * 		 	4. 출력
 */
public class Problem7576 {

	private static int[][] map;
	private static boolean[][] isVisited;
	private static List<int[]> position;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int m;
	private static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		m = Integer.parseInt(stringTokenizer.nextToken());
		n = Integer.parseInt(stringTokenizer.nextToken());

		map = new int[n][m];
		isVisited = new boolean[n][m];
		position = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(stringTokenizer.nextToken());

				if (num == 1) {
					position.add(new int[]{i, j});
				}

				if (num == -1) {
					isVisited[i][j] = true;
				}

				map[i][j] = num;
			}
		}

		while (!position.isEmpty()) {
			int row = position.get(0)[0];
			int column = position.get(0)[1];
			position.remove(0);

			bfs(row, column);
		}

		int max = 0;

		for (int[] i : map) {
			for (int j : i) {
				if (j == 0) {
					System.out.println(0);
					return;
				}

				if (max < j) {
					max = j;
				}
			}
		}

		System.out.println(max - 1);

	}

	private static void bfs(int row, int column) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{row, column});
		isVisited[row][column] = true;

		while (!queue.isEmpty()) {
			int currentRow = queue.peek()[0];
			int currentColumn = queue.peek()[1];
			queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = currentRow + dy[i];
				int nextColumn = currentColumn + dx[i];

				if (nextColumn >= 0 && nextColumn < m && nextRow >= 0 && nextRow < n) {
					if (map[nextRow][nextColumn] == 0 && !isVisited[nextRow][nextColumn]) {
						queue.add(new int[]{nextRow, nextColumn});
						map[nextRow][nextColumn] = map[currentRow][currentColumn] + 1;
						isVisited[nextRow][nextColumn] = true;
					}
				}
			}
		}
	}
}
