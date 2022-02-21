package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1012
 */
public class Problem1012 {

	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static final String NEW_LINE = "\n";
	private static int[][] array;
	private static boolean[][] isVisited;
	private static int count;
	private static int M;
	private static int N;

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			array = new int[M][N];
			isVisited = new boolean[M][N];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				array[x][y] = 1;
			}

			count = 0;

			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (array[j][k] == 0) {
						continue;
					}

					if (!isVisited[j][k]) {
						dfs(j, k);
						count++;
					}
				}
			}

			sb.append(count)
					.append(NEW_LINE);
		}

		System.out.println(sb);
	}

	private static void dfs(int x, int y) {

		if (isVisited[x][y]) {
			return;
		}

		isVisited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
				continue;
			}

			if (!isVisited[nextX][nextY] && (array[nextX][nextY] == 1)) {
				dfs(nextX, nextY);
			}
		}
	}
}

