package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10830
 */
public class Problem10830 {

	private static long[][] result;
	private static int n;
	private static final int MOD = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		n = Integer.parseInt(stringTokenizer.nextToken());
		long b = Long.parseLong(stringTokenizer.nextToken());

		long[][] array = new long[n][n];
		result = new long[n][n];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		result = pow(array, b);

		if (b == 1L) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					result[i][j] %= MOD;
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (long[] i : result) {
			for (long j : i) {
				stringBuilder.append(j)
						.append(" ");
			}
			stringBuilder.append("\n");
		}

		System.out.println(stringBuilder);
	}

	private static long[][] pow(long[][] array, long b) {
		if (b == 1L) {
			return array;
		}

		long[][] temp = pow(array, b / 2);

		long[][] k = multiply(temp, temp);

		if (b % 2 == 1) {
			return multiply(k, array);
		}

		return k;
	}

	private static long[][] multiply(long[][] a, long[][] b) {

		long[][] temp = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					temp[i][j] += ((a[i][k] % MOD) * (b[k][j] % MOD)) % MOD;
					temp[i][j] %= MOD;
				}
			}
		}

		return temp;
	}
}
