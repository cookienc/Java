package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/9093
 */
public class Problem9093 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			String[] str = br.readLine().split(" ");

			for (int i = 0; i < str.length; i++) {
				String word = str[i];
				int length = word.length() - 1;
				for (int j = length; j >= 0; j--) {
					sb.append(word.charAt(j));
				}
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
