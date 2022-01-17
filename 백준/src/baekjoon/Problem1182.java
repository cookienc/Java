package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1182
 */
public class Problem1182 {

	private static int[] array;
	private static boolean[] isVisited;
	private static int count = 0;
	private static int N;
	private static int S;

	private static int sum = 0;

	private static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
		N = Integer.parseInt(stringTokenizer.nextToken());
		S = Integer.parseInt(stringTokenizer.nextToken());

		array = new int[N];
		isVisited = new boolean[N];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			sum = 0;
			dfs(0, 0, i);
		}

		System.out.println(count);
	}

	private static void dfs(int depth, int start, int choice) {

		if (depth == choice) {
			for (int i = 0; i < N; i++) {
				if (isVisited[i]) {
					sum += array[i];
				}
			}

			if (sum == S) {
				count++;
			}
			sum = 0;
			return;
		}

		for (int i = start; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				dfs(depth + 1, i, choice);
				isVisited[i] = false;
			}
		}
	}
}
