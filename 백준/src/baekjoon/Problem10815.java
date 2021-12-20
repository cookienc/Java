package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10815
 */
public class Problem10815 {

	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		int n = Integer.parseInt(bufferedReader.readLine());

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(array);

		int m = Integer.parseInt(bufferedReader.readLine());
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(stringTokenizer.nextToken());
			stringBuilder.append(binarySearch(num))
					.append(" ");
		}
		System.out.println(stringBuilder);
	}

	private static int binarySearch(int key) {
		int low = 0;
		int high = array.length - 1;
		int mid = 0;

		while (low <= high) {

			mid = low + ((high - low) >> 1);

			if (array[mid] <= key) {
				low = mid + 1;
			}

			if (array[mid] > key) {
				high = mid - 1;
			}

		}
		if ((low - 1) >= 0 && key == array[low - 1]) {
			return 1;
		}
		return 0;
	}
}
