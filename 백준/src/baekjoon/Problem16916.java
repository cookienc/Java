package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/16916
 */
public class Problem16916 {

	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] parent = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();

		kmp(parent, pattern);

		System.out.println(answer);
	}

	private static void kmp(char[] parent, char[] pattern) {
		int[] table = makeTable(pattern);
		int parentSize = parent.length;
		int patternSize = pattern.length;

		int j = 0;
		for (int i = 0; i < parentSize; i++) {
			while (j > 0 && parent[i] != pattern[j]) {
				j = table[j - 1];
			}
			if (parent[i] == pattern[j]) {
				if (j == patternSize - 1) {
					answer = 1;
					j = table[j];
				} else {
					j++;
				}
			}
		}
	}

	private static int[] makeTable(char[] pattern) {
		int patternSize = pattern.length;
		int[] arr = new int[patternSize];
		int j = 0;

		for (int i = 1; i < patternSize; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = arr[j - 1];
			}

			if (pattern[i] == pattern[j]) {
				arr[i] = ++j;
			}
		}
		return arr;
	}
}
