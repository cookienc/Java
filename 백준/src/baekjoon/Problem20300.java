package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/20300
 */
public class Problem20300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		int length = arr.length;
		long max = 0;
		if (length % 2 == 0) {
			for (int i = 0; i < length / 2; i++) {
				long value = arr[i] + arr[length - 1 - i];
				max = Math.max(max, value);
			}
		} else {
			max = arr[length - 1];
			for (int i = 0; i < (length - 1) / 2; i++) {
				long value = arr[i] + arr[length - 2 - i];
				max = Math.max(max, value);
			}
		}
		System.out.println(max);
	}
}
