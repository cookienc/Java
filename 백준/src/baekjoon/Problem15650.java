package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15650
 * 참고: https://st-lab.tistory.com/115
 */
public class Problem15650 {

	public static int[] arr;
	public static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		arr = new int[M];

		dfs(N, M, 1, 0);
		System.out.println(stringBuilder);

	}

	public static void dfs(int N, int M, int start, int depth) {

		if (depth == M) {
			for (int val : arr) {
				stringBuilder.append(val).append(' ');
			}
			stringBuilder.append('\n');
			return;
		}

		for (int i = start; i <= N; i++) {

			arr[depth] = i;
			dfs(N, M, i + 1, depth + 1);

		}
	}
}