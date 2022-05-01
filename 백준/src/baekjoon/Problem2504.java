package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/2504
 */
public class Problem2504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		Stack<Character> stack = new Stack<>();

		boolean flag = true;
		int cnt = 1;
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push(c);
				cnt *= 2;
				continue;
			} else if (c == '[') {
				stack.push(c);
				cnt *= 3;
				continue;
			}

			if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					flag = false;
					break;
				}

				if (s.charAt(i - 1) == '(') {
					answer += cnt;
				}
				stack.pop();
				cnt /= 2;
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					flag = false;
					break;
				}

				if (s.charAt(i - 1) == '[') {
					answer += cnt;
				}
				stack.pop();
				cnt /= 3;
			} else {
				flag = false;
				break;
			}
		}

		if (!flag || !stack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(answer);
		}
	}
}
