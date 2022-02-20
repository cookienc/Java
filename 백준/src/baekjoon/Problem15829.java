package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/15829
 */
public class Problem15829 {

	public static final int MOD = 1234567891;
	public static final int r = 31;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(bf.readLine());
		long[] array = new long[L];

		array[0] = 1;
		for (int i = 1; i < L; i++) {
			array[i] = array[i - 1] * r;
		}

		String word = bf.readLine();
		for (int i = 0; i < L; i++) {
			int hashNum = word.charAt(i) - 'a' + 1;
			array[i] *= hashNum;
		}

		int sum = 0;
		for (long l : array) {
			sum += l % MOD;
		}

		System.out.println(sum % MOD);
	}
}
