package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/10988
 */
public class Problem10988 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();
		int length = word.length;

		boolean isTrue = true;
		for (int i = 0; i < length / 2; i++) {
			int low = i;
			int high = (length - 1) - i;
			if (word[low] != word[high]) {
				isTrue = false;
				break;
			}
		}

		if (isTrue) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}
