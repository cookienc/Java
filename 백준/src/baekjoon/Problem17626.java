package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/17626
 */
public class Problem17626 {

	public static final int MAX_SIZE = 50_001;
	private static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		dp = new int[MAX_SIZE];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				int tmp = dp[i - j * j] + 1;
				min = Math.min(tmp, min);
			}
			dp[i] = min;
		}
		System.out.println(dp[N]);
	}
}