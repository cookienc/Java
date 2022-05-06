package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 출처: https://www.acmicpc.net/problem/5052
 */
public class Problem5052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			Map<String, String> phoneBook = new HashMap<>();

			for (int j = 0; j < n; j++) {
				String num = br.readLine();
				phoneBook.put(num, num);
			}

			boolean match = false;
			StringBuilder sb;
			for (String num : phoneBook.keySet()) {
				sb = new StringBuilder();
				for (int j = 0; j < num.length() - 1; j++) {
					sb.append(num.charAt(j));

					if (phoneBook.containsKey(sb.toString())) {
						match = true;
						break;
					}
				}

				if (match) {
					break;
				}
			}

			if (match) {
				answer.append("NO").append("\n");
			} else {
				answer.append("YES").append("\n");
			}
		}
		System.out.println(answer);
	}
}
