package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/11365
 */
public class Problem11365 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			String password = br.readLine();

			if ("END".equals(password)) {
				break;
			}

			char[] words = password.toCharArray();
			for (int i = words.length - 1; i >= 0; i--) {
				sb.append(words[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
