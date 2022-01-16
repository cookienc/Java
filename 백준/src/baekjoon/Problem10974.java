package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/10974
 */
public class Problem10974 {

	private static StringBuilder stringBuilder;
	private static int[] array;
	private static boolean[] isVisited;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());

		stringBuilder = new StringBuilder();
		array = new int[N];
		isVisited = new boolean[N];

		dfs(0);

		System.out.println(stringBuilder);
	}

	private static void dfs(int depth) {
		if (depth == N) {
			for (int i : array) {
				stringBuilder.append(i)
						.append(" ");
			}
			stringBuilder.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				array[depth] = i + 1;
				dfs(depth + 1);
				isVisited[i] = false;
			}
		}
	}
}
