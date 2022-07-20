package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 출처: https://www.acmicpc.net/problem/12026
 */
public class Problem12026 {

	private static char[] map;
	private static int[] dp;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = br.readLine().toCharArray();
		dp = new int[map.length];
		Arrays.fill(dp, 1_000_000);
		find();

		if (dp[N - 1] == 1_000_000) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[N - 1]);
	}

	private static void find() {
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			char next = next(map[i]);

			for (int j = i + 1; j < N; j++) {
				if (map[j] == next) {
					dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
				}
			}
		}
	}

	private static char next(char word) {
		char before = 'A';

		switch (word) {
			case 'B':
				before = 'O';
				break;
			case 'O':
				before = 'J';
				break;
			case 'J':
				before = 'B';
				break;
		}

		return before;
	}
}

