package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1003
 */
public class Problem1003 {

	public static final String SPACE = " ";
	public static final String NEW_LINE = System.getProperty("line.separator");
	private static StringBuilder stringBuilder = new StringBuilder();
	private static Integer[][] dp = new Integer[41][2];

	public static void main(String[] args) throws IOException {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());

		dp[0][0] = 1;
		dp[0][1] = 0;

		for (int i = 0; i < T; i++) {
			int num = Integer.parseInt(bufferedReader.readLine());
			fibonacciZero(num);
			fibonacciOne(num);
			stringBuilder.append(dp[num][0])
					.append(SPACE)
					.append(dp[num][1])
					.append(NEW_LINE);
		}
		System.out.println(stringBuilder);
	}

	private static int fibonacciZero(int num) {

		if (num >= 3 && dp[num][0] == null) {
			dp[num][0] = fibonacciZero(num - 1) + fibonacciZero(num - 2);
		}

		if (num == 1) {
			dp[num][0] = 0;
		}

		if (num == 2) {
			dp[num][0] = 1;
		}

		return dp[num][0];
	}

	private static int fibonacciOne(int num) {

		if (num >= 3 && dp[num][1] == null) {
			dp[num][1] = fibonacciOne(num - 1) + fibonacciOne(num - 2);
		}

		if (num == 1) {
			dp[num][1] = 1;
		}

		if (num == 2) {
			dp[num][1] = 1;
		}

		return dp[num][1];
	}
}
