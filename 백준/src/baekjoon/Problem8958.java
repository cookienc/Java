package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/8958
 */
public class Problem8958 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		for (int i = 0; i < N; i++) {
			calculateScore(bf.readLine());
		}

		System.out.println(sb);
	}

	private static void calculateScore(String str) {
		int length = str.length();

		int sum = 0;
		int continuity = 1;

		for (int i = 0; i < length; i++) {
			if ('O' == str.charAt(i)) {
				sum += continuity;
				continuity++;
				continue;
			}
			continuity = 1;
		}

		sb.append(sum)
				.append(NEW_LINE);
	}
}
