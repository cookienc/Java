package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15649
 * 참고: https://st-lab.tistory.com/114#%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 */
public class Problem15649 {
	public static int[] array;
	public static boolean[] isVisited;
	public static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		array = new int[M];
		isVisited = new boolean[N];
		dfs(N, M, 0);
		System.out.println(stringBuilder);

	}

	public static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int val : array) {
				stringBuilder.append(val).append(' ');
			}
			stringBuilder.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				array[depth] = i + 1;
				dfs(N, M, depth + 1);
				isVisited[i] = false;
			}
		}
	}
}
