package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2110
 * 참고: https://st-lab.tistory.com/277?category=948182
 */
public class Problem2110 {

	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());

		array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(bufferedReader.readLine());
		}

		Arrays.sort(array);

		int minDistance = 1;
		int maxDistance = array[n - 1] - array[0] + 1;
		int mid = 0;

		while (minDistance <= maxDistance) {

			mid = minDistance + ((maxDistance - minDistance) >> 1);

			if (install(mid) < c) {
				maxDistance = mid - 1;
			}

			if (install(mid) >= c) {
				minDistance = mid + 1;
			}
		}

		System.out.println(minDistance - 1);
	}

	private static int install(int distance) {

		int count = 1;
		int setLastLocate = array[0];

		for (int i = 1; i < array.length; i++) {
			int currentLocate = array[i];

			if (currentLocate - setLastLocate >= distance) {
				count++;
				setLastLocate = currentLocate;
			}
		}
		return count;
	}
}
