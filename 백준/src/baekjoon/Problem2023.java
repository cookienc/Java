package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2023
 */
public class Problem2023 {

	private static int[] prime = {1, 3, 7, 9};
	private static int N;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();

		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);

		System.out.println(sb);
	}

	private static void dfs(int number, int cnt) {
		if (cnt == N) {
			sb.append(number).append("\n");
			return;
		}

		for (int i = 0; i < 4; i++) {
			int next = number * 10 + prime[i];

			boolean flag = false;
			for (int j = 2; j < next; j++) {
				if (next % j == 0) {
					flag = true;
					break;
				}
			}

			if (flag) {
				continue;
			}

			dfs(next, cnt + 1);
		}
	}
}
