package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11050
 */
public class Problem11050 {

	private static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		array = new int[N + 1][K + 1];

		System.out.println(combination(N, K));
	}

	private static int combination(int n, int k) {

		if (n == 1 || n == k || k == 0) {
			return array[n][k] = 1;
		}

		if (k == 1) {
			return array[n][k] = n;
		}

		if (array[n][k] != 0) {
			return array[n][k];
		}

		return array[n][k] = combination(n - 1, k - 1) + combination(n - 1, k);
	}
}
