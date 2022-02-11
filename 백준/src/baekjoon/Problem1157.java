package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

/**
 * 출처: https://www.acmicpc.net/problem/1157
 */
public class Problem1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String word = bf.readLine();

		word = word.toUpperCase(Locale.ROOT);

		Integer[] array = new Integer[26];
		Arrays.fill(array, 0);

		for (int i = 0; i < word.length(); i++) {
			int index = (word.charAt(i) - 'A');
			array[index]++;
		}
		int index = 0;
		int max = array[0];

		for (int i = 1; i < 26; i++) {
			if (max < array[i]) {
				max = array[i];
				index = i;
			}
		}

		Arrays.sort(array, (a1, a2) -> (a2 - a1));

		if (array[0].equals(array[1])) {
			System.out.println("?");
		} else {
			System.out.println((char) (index + 'A'));
		}
	}
}
