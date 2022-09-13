package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/21314
 */
public class Problem21314 {

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] nums = br.readLine().toCharArray();

		getMax(nums);
		getMin(nums);
		System.out.println(sb);
	}

	private static void getMax(char[] nums) {
		int m = 0;
		int k = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 'M') {
				m++;
			} else {
				k++;
			}

			if (k == 0) {
				continue;
			}

			sb.append(5);
			k = 0;
			while (m-- > 0) {
				sb.append(0);
			}
			m = 0;
		}

		if (m != 0) {
			sb.append(1);
			m--;
			while (m-- > 0) {
				sb.append(1);
			}
		}

		sb.append("\n");
	}

	private static void getMin(char[] nums) {
		int m = 0;
		int k = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 'M') {
				m++;
			} else {
				k++;
			}

			if (k == 0) {
				continue;
			}

			if (m != 0) {
				sb.append(1);
				m--;
				while (m-- > 0) {
					sb.append(0);
				}
				m = 0;
			}

			sb.append(5);
			k = 0;
		}

		if (m != 0) {
			sb.append(1);
			m--;
			while (m-- > 0) {
				sb.append(0);
			}
		}
	}
}
