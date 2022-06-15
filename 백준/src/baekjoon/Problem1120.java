package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1120
 */
public class Problem1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] word = br.readLine().split(" ");

		String A = word[0];
		String B = word[1];

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < B.length(); i++) {
			int cnt = A.length();

			if (i + cnt > B.length()) { // 범위를 넘으면
				break;
			}

			for (int j = 0; j < A.length(); j++) {


				if (A.charAt(j) == B.charAt(i + j)) {
					cnt--;
				}
			}
			min = Math.min(min, cnt);
		}
		System.out.println(min);
	}
}
