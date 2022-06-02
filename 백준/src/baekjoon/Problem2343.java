package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2343
 */
public class Problem2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		int low = 0;
		int high = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			low = Math.max(low, arr[i]);
			high += arr[i];
		}

		low--;

		while (low + 1 < high) {
			int size = low + (high - low) / 2;

			int count = countBlueRay(arr, size);

			if (count <= M) {
				high = size;
			} else {
				low = size;
			}
		}

		System.out.println(high);
	}

	private static int countBlueRay(int[] arr, int size) {
		int count = 1;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			if (sum + arr[i] > size) {
				sum = arr[i];
				count++;
				continue;
			}

			sum += arr[i];
		}

		return count;
	}
}
