package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/4949
 */
public class Problem4949 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = bf.readLine();

			if (str.equals(".")) {
				break;
			}

			Stack<Character> stack = new Stack<>();

			boolean isBalance = true;
			for (int i = 0; i < str.length(); i++) {
				Character word = str.charAt(i);
				if (word.equals('(') || word.equals('[')) {
					stack.push(word);
				}

				if (word.equals(')')) {
					if (stack.size() != 0 && stack.peek().equals('(')) {
						stack.pop();
						continue;
					}
					printNo();
					isBalance = false;
					break;
				}

				if (word.equals(']')) {
					if (stack.size() != 0 && stack.peek().equals('[')) {
						stack.pop();
						continue;
					}
					printNo();
					isBalance = false;
					break;
				}
			}

			if (isBalance) {
				if (stack.isEmpty()) {
					printYes();
				} else {
					printNo();
				}
			}
		}
		System.out.println(sb);
	}

	private static void printYes() {
		sb.append("yes")
				.append(NEW_LINE);
	}

	private static void printNo() {
		sb.append("no")
				.append(NEW_LINE);
	}
}
