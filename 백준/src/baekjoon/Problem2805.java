package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2805
 */
public class Problem2805 {

	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		array = new int[n];

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(array);

		long low = 1;
		long high = array[n - 1];
		long mid = 0;

		while (low <= high) {
			mid = low + ((high - low) >> 1);

			long length = 0;

			for (int height : array) {
				if (height - mid > 0) {
					length += height - mid;
				}
			}

			if (length < m) {
				high = mid - 1;
			}

			if (length >= m) {
				low = mid + 1;
			}
		}

		System.out.println(low - 1);
	}
}
