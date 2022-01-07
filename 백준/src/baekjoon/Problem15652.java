package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15652
 */
public class Problem15652 {

	private static int N;
	private static int M;
	private static int[] array;
	private static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());

		array = new int[M];
		stringBuilder = new StringBuilder();

		dfs(0, 1);

		System.out.println(stringBuilder);
	}

	private static void dfs(int depth, int start) {
		if (depth == M) {
			for (int i : array) {
				stringBuilder.append(i)
						.append(" ");
			}
			stringBuilder.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			array[depth] = i;
			dfs(depth + 1, i);
		}
	}
}
