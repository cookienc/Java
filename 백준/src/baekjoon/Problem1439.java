package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1439
 */
public class Problem1439 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int zero = 0;
		int one = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == '0' && s.charAt(i - 1) == '1') {
				one++;
			} else if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
				zero++;
			}
		}

		if (s.charAt(s.length() - 1) == '0') {
			zero++;
		} else {
			one++;
		}

		if (one > zero) {
			System.out.println(zero);
		} else {
			System.out.println(one);
		}
	}
}
