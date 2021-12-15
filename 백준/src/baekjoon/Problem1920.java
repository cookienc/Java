package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1920 {

	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		array = new int[n];

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(array);

		int m = Integer.parseInt(bufferedReader.readLine());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		StringBuilder stringBuilder = new StringBuilder();

		for (int i = 0; i < m; i++) {
			int key = Integer.parseInt(stringTokenizer.nextToken());
			if (binarySearch(key) < 0) {
				stringBuilder.append(0)
						.append("\n");
			} else {
				stringBuilder.append(1)
						.append("\n");
			}
		}
		System.out.println(stringBuilder);
	}

	private static int binarySearch(int key) {

		int low = 0;
		int high = array.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) >> 1;

			if (key < array[mid]) {
				high = mid - 1;
			}

			if (key > array[mid]) {
				low = mid + 1;
			}

			if (key == array[mid]) {
				return mid;
			}
		}
		return -1;
	}
}
