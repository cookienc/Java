package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem10816 {
	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();

		int n = Integer.parseInt(bufferedReader.readLine());

		array = new int[n];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(array);

		int m = Integer.parseInt(bufferedReader.readLine());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < m; i++) {
			int key = Integer.parseInt(stringTokenizer.nextToken());
			stringBuilder.append(upperBound(key) - lowerBound(key))
					.append(" ");
		}

		System.out.println(stringBuilder);
	}

	private static int lowerBound(int key) {

		int low = 0;
		int high = array.length;
		int mid = 0;

		while (low < high) {

			mid = low + ((high - low) >> 2);

			if (key <= array[mid]) {
				high = mid;
			}

			if (key > array[mid]) {
				low = mid + 1;
			}
		}
		return low;
	}

	private static int upperBound(int key) {

		int low = 0;
		int high = array.length;
		int mid = 0;

		while (low < high) {

			mid = low + ((high - mid) >> 2);

			if (key < array[mid]) {
				high = mid;
			}

			if (key >= array[mid]) {
				low = mid + 1;
			}
		}
		return low;
	}
}
