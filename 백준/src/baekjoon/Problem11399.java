package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11399
 */
public class Problem11399 {

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

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += array[i] * (n - i);
		}

		System.out.println(sum);
	}
}
