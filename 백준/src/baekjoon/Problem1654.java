package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1654
 */
public class Problem1654 {

	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int k = Integer.parseInt(stringTokenizer.nextToken());
		int n = Integer.parseInt(stringTokenizer.nextToken());

		array = new int[k];

		for (int i = 0; i < k; i++) {
			array[i] = Integer.parseInt(bufferedReader.readLine());
		}

		Arrays.sort(array);

		long low = 1;
		long high = array[k - 1];
		long mid = 0;

		while (low <= high) {

			long count = 0;

			mid = low + ((high - low) >> 1);


			for (int i = 0; i < array.length; i++) {
				count += (array[i] / mid);
			}

			if (count < n) {
				high = mid - 1;
			}

			if (count >= n) {
				low = mid + 1;
			}
		}
		System.out.println(high);
	}
}
