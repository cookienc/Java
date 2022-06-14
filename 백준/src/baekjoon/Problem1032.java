package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1032
 */
public class Problem1032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[] origin = null;
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				origin = br.readLine().toCharArray();
				continue;
			}

			char[] compare = br.readLine().toCharArray();
			for (int j = 0; j < origin.length; j++) {
				if (compare[j] != origin[j]) {
					origin[j] = '?';
				}
			}
		}
		for (char c : origin) {
			System.out.print(c);
		}
	}
}
