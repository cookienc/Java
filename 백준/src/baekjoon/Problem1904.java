package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1904
 */
public class Problem1904 {
	public static final int MOD = 15746;
	private static Integer[] dp = new Integer[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 5;
		dp[5] = 8;

		System.out.println(makeBinary(N));
	}

	private static int makeBinary(int N) {

		for (int i = 6; i <= N; i++) {
			dp[i] = ((dp[i - 1] % MOD)+ (dp[i - 2] % MOD)) % MOD;
		}

		return dp[N];
	}
}
