package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1010
 */
public class Problem1010 {

	private static BigInteger[] dp;

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bufferedReader.readLine());

		StringTokenizer stringTokenizer;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < T; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int N = Integer.parseInt(stringTokenizer.nextToken());
			int M = Integer.parseInt(stringTokenizer.nextToken());

			dp = new BigInteger[M + 1];

			dp[0] = new BigInteger("1");
			dp[1] = new BigInteger("1");

			stringBuilder.append(combination(N, M)).append("\n");
		}

		System.out.println(stringBuilder);
	}

	private static BigInteger combination(int n, int m) {
		return factorial(m).divide(factorial(m - n).multiply(factorial(n)));
	}

	private static BigInteger factorial(int num) {
		if (dp[num] == null) {
			dp[num] = factorial(num - 1).multiply(new BigInteger(String.valueOf(num)));
		}

		return dp[num];
	}
}
