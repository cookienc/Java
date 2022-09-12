package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 출처: https://www.acmicpc.net/problem/11508
 */
public class Problem11508 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		long sum = 0;
		for (int i = 0; i < N; i++) {
			if (i % 3 == 2) {
				continue;
			}
			sum += arr[i];
		}

		System.out.println(sum);
	}
}
