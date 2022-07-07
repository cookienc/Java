package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2581
 */
public class Problem2581 {

	private static boolean[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		primeNumber(N);

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i <= N; i++) {
			if (arr[i]) {
				sum += i;
				min = Math.min(min, i);
			}
		}

		if (sum == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(min);
	}

	private static void primeNumber(int N) {
		arr = new boolean[N + 1];
		Arrays.fill(arr, true);

		arr[0] = false;
		arr[1] = false;

		for (int i = 2; i < Math.sqrt(N); i++) {
			for (int j = i * i; j <= N; j += i) {
				arr[j] = false;
			}
		}
	}
}
