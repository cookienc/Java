package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11401
 * 참고: https://st-lab.tistory.com/241?category=922819
 */
public class Problem11401 {

	private static long[] factorial;
	private static final long num = 1000000007L;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int k = Integer.parseInt(stringTokenizer.nextToken());

		factorial = new long[n + 1];

		makeFactorial(n);

		long a = factorial[n];
		long b = (factorial[k] * factorial[n - k]) % num;

		long answer = (a % num) * (pow(b, num - 2) % num) % num;

		System.out.println(answer);
	}

	private static void makeFactorial(int n) {

		factorial[0] = 1L;
		factorial[1] = 1L;

		if (n < 2) {
			return;
		}

		for (int i = 2; i <= n; i++) {
			factorial[i] = (factorial[i - 1] * i) % num;
		}
	}

	private static long pow(long n, long k) {

		if (k == 1) {
			return n % num;
		}

		long temp = pow(n, k / 2);

		if (k % 2 == 1) {
			return (temp * temp % num) * n % num;
		}

		return temp * temp % num;
	}
}
