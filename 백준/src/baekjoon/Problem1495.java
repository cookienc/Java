package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1495
 * 참조: https://steady-coding.tistory.com/172
 */
public class Problem1495 {

	private static int[][] dp;
	private static int[] volume;

	private static int N;
	private static int S;
	private static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());


		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new int[M + 1][N];
		volume = new int[N];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		for (int[] arr : dp) {
			Arrays.fill(arr, -2);
		}

		System.out.println(recursion(S, 0));
	}

	public static int recursion(int sum, int idx) {
		if (sum > M || sum < 0) {
			return -1;
		}

		if (idx == N) {
			return sum;
		}

		if (dp[sum][idx] != -2) {
			return dp[sum][idx];
		}

		return dp[sum][idx] = Math.max(dp[sum][idx], Math.max(recursion(sum + volume[idx], idx + 1), recursion(sum - volume[idx], idx + 1)));
	}

}

