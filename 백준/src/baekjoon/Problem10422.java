package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/10422
 */
public class Problem10422 {

	public static final int MOD = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		long[] dp = new long[2501];
		dp[0] = 1;
		dp[2] = 1;

		for (int i = 2; i < 2501; i++) {
			for (int j = 0; j < i; j++) {
				dp[i * 2] += ((dp[j * 2]  % MOD) * (dp[(i - 1 - j) * 2] % MOD)) % MOD;
				dp[i * 2] %= MOD;
			}
		}

		while (T-- > 0) {
			int L = Integer.parseInt(br.readLine());

			if (L % 2 != 0) {
				sb.append(0);
				sb.append("\n");
				continue;
			}

			sb.append(dp[L]);
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
