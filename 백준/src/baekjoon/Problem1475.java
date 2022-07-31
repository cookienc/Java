package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1475
 */
public class Problem1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();
		int[] numbers = new int[11];

		int sixNine = 0;
		int max = 0;
		for (int i = 0; i < word.length; i++) {
			char num = word[i];

			if (num == '6' || num == '9') {
				sixNine++;
				continue;
			}

			int index = num - '0';
			max = Math.max(++numbers[index], max);
		}

		if (max > (int) Math.round((double) sixNine / 2)) {
			System.out.println(max);
		} else {
			System.out.println((int) Math.round((double) sixNine / 2));
		}
	}
}
