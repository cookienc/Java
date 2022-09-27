package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2947
 */
public class Problem2947 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (true) {
			boolean end = true;
			for (int i = 0; i < 5; i++) {
				if (arr[i] != i + 1) {
					end = false;
					break;
				}
			}

			if (end) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);

					for (int num : arr) {
						System.out.print(num + " ");
					}
					System.out.println();
				}
			}
		}
	}

	private static void swap(int[] arr, int i1, int i2) {
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}
}
