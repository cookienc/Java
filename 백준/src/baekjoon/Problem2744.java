package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2744
 */
public class Problem2744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] words = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();
		for (char word : words) {
			if ('a' <= word && word <= 'z') {
				sb.append((char) (word - 'a' + 'A'));
			} else {
				sb.append((char) (word - 'A' + 'a'));
			}
		}

		System.out.println(sb);
	}
}
