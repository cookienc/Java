package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2468
 */
public class Problem2468 {

	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int[][] array;
	private static boolean[][] isVisited;
	private static int N;
	private static int count;
	private static int result = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());

		array = new int[N][N];
		isVisited = new boolean[N][N];

		StringTokenizer stringTokenizer;
		int max = 0;
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				max = Math.max(array[i][j], max);
			}
		}

		int height = 0;

		for (int i = height; i < max; i++) {
			count = 0;
			isVisited = new boolean[N][N];
			getSafePlace(i);
			result = Math.max(result, count);
		}

		System.out.println(result);
	}

	private static void getSafePlace(int height) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j] && array[i][j] > height) {
					count += bfs(i, j, height);
				}
			}
		}
	}

	private static int bfs(int i, int j, int height) {

		if (array[i][j] <= height) {
			return 0;
		}

		Queue<int[]> queue = new LinkedList<>();

		isVisited[i][j] = true;
		queue.offer(new int[]{i, j});

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];

			isVisited[x][y] = true;

			for (int k = 0; k < 4; k++) {
				int nextX = x + dx[k];
				int nextY = y + dy[k];

				if (nextX >= N || nextY >= N || nextX < 0 || nextY < 0) {
					continue;
				}

				if (isVisited[nextX][nextY]) {
					continue;
				}

				if (array[nextX][nextY] > height) {
					isVisited[nextX][nextY] = true;
					queue.offer(new int[]{nextX, nextY});
				}
			}
		}
		return 1;
	}
}
