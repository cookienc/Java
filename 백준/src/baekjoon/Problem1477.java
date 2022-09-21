package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1477
 */
public class Problem1477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 2];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		arr[N] = 0;
		arr[N + 1] = L;

		Arrays.sort(arr);
		int left = 0;
		int right = L - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			int store = getStores(N, arr, mid);

			if (store > M) {
				left = mid;
				continue;
			}

			if (store <= M) {
				right = mid;
			}
		}
		System.out.println(right);
	}

	private static int getStores(int N, int[] arr, int mid) {
		int store = 0;
		for (int i = 1; i < N + 2; i++) {
			int distance = arr[i] - arr[i - 1];
			store += (distance / mid);

			if (distance % mid == 0) {
				store--;
			}
		}
		return store;
	}
}
