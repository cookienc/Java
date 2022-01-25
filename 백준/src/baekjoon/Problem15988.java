package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/15988
 */
public class Problem15988 {
	public static final int MOD = 1000000009;
	private static Long[] dp = new Long[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		dp[1] = 1L;
		dp[2] = 2L;
		dp[3] = 4L;

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < N; i++) {
			stringBuilder.append(findAnswer(Integer.parseInt(bufferedReader.readLine())))
					.append("\n");
		}

		System.out.println(stringBuilder);
	}

	private static Long findAnswer(int num) {

		if (dp[num] == null) {
			for (int i = 4; i <= num; i++) {
				dp[i] = ((dp[i - 1] % MOD) + (dp[i - 2] % MOD) + (dp[i - 3] % MOD)) % MOD;
			}
		}

		return dp[num];
	}
}
