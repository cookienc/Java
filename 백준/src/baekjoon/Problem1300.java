package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 출처: https://www.acmicpc.net/problem/1300
 */
public class Problem1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int low = 0;
		int high = K;
		while (low + 1 < high) {
			int mid = low + (high - low) / 2;

			int sum = 0;
			for (int i = 1; i <= N; i++) {
				sum += Math.min(mid / i, N);
			}

			if (sum >= K) {
				high = mid;
			} else {
				low = mid;
			}
		}
		System.out.println(high);
	}
}
