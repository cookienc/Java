package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1010
 * 참고: https://st-lab.tistory.com/194
 */
public class Problem1010 {

	private static int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bufferedReader.readLine());

		StringTokenizer stringTokenizer;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < T; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int N = Integer.parseInt(stringTokenizer.nextToken());
			int M = Integer.parseInt(stringTokenizer.nextToken());

			stringBuilder.append(combination(M, N)).append("\n");
		}

		System.out.println(stringBuilder);
	}

	private static int combination(int m, int n) {

		if (dp[m][n] > 0) {
			return dp[m][n];
		}

		if (isExitCondition(m, n)) {
			return dp[m][n] = 1;
		}

		dp[m][n] = combination(m - 1, n - 1) + combination(m - 1, n);

		return dp[m][n];
	}

	private static boolean isExitCondition(int m, int n) {
		return n == 0 || n == m;
	}
}
