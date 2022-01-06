package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15649
 */
public class Problem15649 {
	private static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		stringBuilder = new StringBuilder();
		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		int[] array = new int[n];
		int[] output = new int[n];
		boolean[] isVisited = new boolean[n];

		for (int i = 1; i <= n; i++) {
			array[i - 1] = i;
		}

		permutation(array, output, isVisited, 0, n, m);
		System.out.println(stringBuilder);
	}

	private static void permutation(int[] array, int[] output, boolean[] isVisited, int depth, int n, int r) {
		if (depth == r) {
			print(output);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				output[depth] = array[i];
				permutation(array, output, isVisited, depth + 1, n, r);
				isVisited[i] = false;
			}
		}
	}

	private static void print(int[] output) {
		for (int i : output) {
			if (i == 0) {
				continue;
			}
			stringBuilder.append(i)
					.append(" ");
		}
		stringBuilder.append("\n");
	}
}
