package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1316
 */
public class Problem1316 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] alphabet = new boolean[26];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			alphabet = new boolean[26];

			boolean group = true;
			alphabet[word.charAt(0) - 'a'] = true;
			for (int j = 1; j < word.length(); j++) {
				char cur = word.charAt(j);
				char before = word.charAt(j - 1);
				int idx = cur - 'a';
				if (cur != before) {
					if (alphabet[idx]) {
						group = false;
						break;
					}
				}
				alphabet[idx] = true;
			}

			if (group) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
