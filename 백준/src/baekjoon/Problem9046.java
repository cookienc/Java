package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/9046
 */
public class Problem9046 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			char[] words = br.readLine().toCharArray();
			int[] alphabet = new int[26];
			for (char word : words) {
				if (word == ' ') {
					continue;
				}
				alphabet[(int) word - 'a']++;
			}

			int max = 0;
			int index = 0;
			int cnt = 0;
			for (int i = 0; i < 26; i++) {
				if (max < alphabet[i]) {
					index = i;
					max = alphabet[i];
					cnt = 1;
					continue;
				}

				if (max == alphabet[i]) {
					cnt++;
				}
			}

			if (cnt >= 2) {
				System.out.println("?");
				continue;
			}

			System.out.println((char) (index + 'a'));
		}
	}
}
