package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/17413
 */
public class Problem17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] words = br.readLine().toCharArray();
		Stack<Character> answer = new Stack<>();
		Stack<Character> reverse = new Stack<>();

		boolean bracket = false;
		boolean space = false;

		for (char w : words) {
			if (w == ' ' || w == '<') {
				while (!reverse.isEmpty()) {
					answer.add(reverse.pop());
				}
				answer.add(w);

				if (w == '<') {
					bracket = true;
				}
				continue;
			}

			if (w == '>') {
				bracket = false;
				answer.add(w);
				continue;
			}

			if (!bracket) {
				reverse.add(w);
			} else {
				answer.add(w);
			}
		}

		while (!reverse.isEmpty()) {
			answer.add(reverse.pop());
		}

		StringBuilder sb = new StringBuilder();
		for (Character c : answer) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
