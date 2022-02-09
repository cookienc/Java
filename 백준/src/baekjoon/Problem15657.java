package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/156567
 */
public class Problem15657 {
	private static int[] array;
	private static int[] answer;

	private static final StringBuilder stringBuilder = new StringBuilder();

	private static int N;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		array = new int[N];
		answer = new int[M];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(array);

		dfs(0, 0);

		System.out.println(stringBuilder);
	}

	private static void dfs(int start, int depth) {

		if (depth == M) {
			for (int i = 0; i < M; i++) {
				stringBuilder.append(answer[i]).append(" ");
			}
			stringBuilder.append("\n");
			return;
		}

		for (int i = start; i < N; i++) {
			answer[depth] = array[i];
			dfs(i, depth + 1);
		}
	}
}
