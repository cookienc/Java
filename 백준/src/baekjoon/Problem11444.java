package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/11444
 * 참고: https://st-lab.tistory.com/252?category=922819
 */
public class Problem11444 {

	private static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(bufferedReader.readLine());

		if (num == 0) {
			System.out.println(0);
			return;
		}

		if (num == 1) {
			System.out.println(1);
			return;
		}

		long[][] u = {
				{1, 1},
				{1, 0}
		};

		long[][] answer = new long[2][2];
		answer = pow(num, u);
		System.out.println(answer[0][1]);
	}

	private static long[][] pow(long exponent, long[][] u) {

		if (exponent == 1L || exponent == 0L) {
			return u;
		}

		long[][] temp = pow(exponent / 2, u);

		long[][] answer = multiply(temp, temp);

		if (exponent % 2 == 1L) {
			return multiply(answer, u);
		}

		return answer;
	}

	private static long[][] multiply(long[][] a, long[][] b) {

		long[][] result = new long[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result[i][j] += a[i][k] * b[k][j];
					result[i][j] %= MOD;
				}
			}
		}

		return result;
	}
}
