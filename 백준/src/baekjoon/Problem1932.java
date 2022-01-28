package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1932
 */
public class Problem1932 {

	public static int[][] dp;
	public static int[][] array;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());

		dp = new int[N + 1][N + 1];
		array = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= i; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int[] i : dp) {
			Arrays.fill(i, -1);
		}

		for (int i = 1; i <= N; i++) {
			dp[N][i] = array[N][i];
		}

		System.out.println(recursion(1, 1));


	}

	private static int recursion(int depth, int idx) {

		if (depth == N) {
			return dp[depth][idx];
		}

		if (dp[depth][idx] == -1) {
			dp[depth][idx] = Math.max(recursion(depth + 1, idx),
					recursion(depth + 1, idx + 1)) + array[depth][idx];
		}

		return dp[depth][idx];
	}
}
