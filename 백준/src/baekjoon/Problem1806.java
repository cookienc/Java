package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1806
 */
public class Problem1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] array = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int low = 0;
		int high = 0;
		int sum = array[0];
		int size = Integer.MAX_VALUE;

		while (low <= high) {

			if (sum >= S) {
				size = Math.min(size, high - low + 1);
				sum -= array[low];
				low++;
			}

			if (sum < S) {
				high++;
				if (high >= N) {
					break;
				}
				sum += array[high];
			}

		}

		if (size == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(size);
	}
}
