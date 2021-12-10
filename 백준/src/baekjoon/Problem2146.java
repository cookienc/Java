package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2146 {

	private static int[][] map;
	private static boolean[][] isVisited;
	private static final int[] dx = {1, -1, 0, 0};
	private static final int[] dy = {0, 0, 1, -1};
	private static int count = 2;
	private static int n;
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		n = Integer.parseInt(bufferedReader.readLine());

		map = new int[n][n];
		isVisited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(stringTokenizer.nextToken());
				if (num == 0) {
					isVisited[i][j] = true;
				}
				map[i][j] = num;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !isVisited[i][j]) {
					colorIsland(i, j); // 섬을 구분
					count++;
				}
			}
		}


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > 1) {
					isVisited = new boolean[n][n];
					countBridge(i, j); // 다리 개수 찾기
				}
			}
		}
		System.out.println(answer);
	}

	private static void countBridge(int row, int column) {
		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(row, column, 0));
		isVisited[row][column] = true;
		int currentLand = map[row][column];

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = point.row + dy[i];
				int nextColumn = point.column + dx[i];

				boolean isNotBoundary =
						(nextRow < 0) ||
						(nextRow >= n) ||
						(nextColumn < 0) ||
						(nextColumn >= n) ||
						isVisited[nextRow][nextColumn] ||
						map[nextRow][nextColumn] == currentLand;

				if (isNotBoundary) {
					continue;
				}

				isVisited[nextRow][nextColumn] = true;

				if (map[nextRow][nextColumn] == 0) {
					queue.add(new Point(nextRow, nextColumn, point.count + 1));
					continue;
				}
				answer = Math.min(answer, point.count);
			}
		}
	}

	private static void colorIsland(int row, int column) {

		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(row, column, 0));
		if (map[row][column] != 0) {
			map[row][column] += count;
		}
		isVisited[row][column] = true;

		while (!queue.isEmpty()) {
			Point point = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextRow = point.row + dy[i];
				int nextColumn = point.column + dx[i];

				boolean isNotBoundary =
						(nextRow < 0) ||
						(nextRow >= n) ||
						(nextColumn < 0) ||
						(nextColumn >= n) ||
						isVisited[nextRow][nextColumn];

				if (isNotBoundary) {
					continue;
				}

				if (map[nextRow][nextColumn] == 1) {
					queue.add(new Point(nextRow, nextColumn, 0));
					map[nextRow][nextColumn] += count;
					isVisited[nextRow][nextColumn] = true;
				}
			}
		}
	}

	private static class Point {
		int row;
		int column;
		int count;

		private Point(int row, int column, int count) {
			this.row = row;
			this.column = column;
			this.count = count;
		}
	}
}
