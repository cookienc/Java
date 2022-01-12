package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());

		int end = Integer.MAX_VALUE;
		int count666 = 0;
		int answer = 0;

		for (int i = 666; i < end; i++) {
			String s = String.valueOf(i);
			for (int j = 0; j < s.length() - 2; j++) {
				if (s.charAt(j) == '6' &&
						s.charAt(j + 1) == '6' &&
						s.charAt(j + 2) == '6') {

					count666++;
					break;
				}
			}

			if (count666 == N) {
				answer = i;
				break;
			}
		}

		System.out.println(answer);
	}
}
/**
 * 1666
 * 2666
 * ...
 * 9666
 * <p>
 * 10666
 * 11666
 * 12666
 * 13666
 * 14666 ->14000
 * 15666 ->15000
 * <p>
 * 16660 ->10000
 * 16661 ->10001
 * 16662
 * ...
 * 16666
 * 16667
 * 16668
 * 16669
 * <p>
 * 17666
 */
