package baekjoon;

import java.util.Arrays;

/**
 * 출처: https://www.acmicpc.net/problem/4673
 */
public class Problem4637 {
	public static void main(String[] args) {
		boolean[] array = new boolean[10001];

		Arrays.fill(array, true);

		for (int i = 1; i < array.length; i++) {
			String number = String.valueOf(i);
			int sum = i;

			for (int j = 0; j < number.length(); j++) {
				sum += number.charAt(j) - '0';
			}

			if (sum > 10000) {
				continue;
			}

			array[sum] = false;
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i < array.length; i++) {
			if (!array[i]) {
				continue;
			}
			stringBuilder.append(i)
					.append("\n");
		}

		System.out.println(stringBuilder);
	}
}
