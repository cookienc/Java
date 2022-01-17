package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14889
 * 참고: https://st-lab.tistory.com/122
 */
public class Problem14889 {

	private static int[][] array;
	private static boolean[] isVisited;
	private static int min = Integer.MAX_VALUE;
	private static int N;

	private static StringBuilder stringBuilder = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());

		array = new int[N + 1][N + 1];
		isVisited = new boolean[N + 1];

		StringTokenizer stringTokenizer;
		for (int i = 1; i <= N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		dfs(0, 1);
		System.out.println(min);
	}

	private static void dfs(int depth, int start) {

		if (depth == N / 2) {
			int teamStart = 0;
			int teamLink = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = i + 1; j <= N; j++) {
					if (isVisited[i] && isVisited[j]) {
						teamStart += array[i][j] + array[j][i];
					}

					if (!isVisited[i] && !isVisited[j]) {
						teamLink += array[i][j] + array[j][i];
					}
				}
			}

			int val = Math.abs(teamStart - teamLink);

			if (val == 0) {
				System.out.println(val);
				System.exit(0);
			}

			min = Math.min(val, min);
		}

		for (int i = start; i <= N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				dfs(depth + 1, i);
				isVisited[i] = false;
			}
		}
	}
}
