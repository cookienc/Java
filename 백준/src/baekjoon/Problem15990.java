package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/15990
 * 참조: https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-15990-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-5-Java
 */
public class Problem15990 {
	public static final int MOD = 1000000009;
	private static long[][] dp = new long[1000001][4];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		dp[1][1] = 1L;
		dp[2][2] = 1L;
		dp[3][1] = 1L;
		dp[3][2] = 1L;
		dp[3][3] = 1L;

		for(int i = 4; i <= 100000; i++) {
			dp[i][1] = (dp[i-1][2] % MOD + dp[i-1][3] % MOD) % MOD;
			dp[i][2] = (dp[i-2][1] % MOD + dp[i-2][3] % MOD) % MOD;
			dp[i][3] = (dp[i-3][1] % MOD + dp[i-3][2] % MOD) % MOD;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(bufferedReader.readLine());
			stringBuilder.append((dp[num][1] + dp[num][2] + dp[num][3]) % MOD)
					.append("\n");
		}

		System.out.println(stringBuilder);
	}
}