package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/20365
 */
public class Problem20365 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] colors = br.readLine().toCharArray();

		int B = 0;
		int R = 0;
		Stack<Character> stack = new Stack<>();

		for (char color : colors) {
			if (!stack.isEmpty() && stack.peek() == color) {
				continue;
			}
			stack.push(color);
		}

		for (Character c : stack) {
			if (c == 'R') {
				R++;
			} else {
				B++;
			}
		}


		System.out.println(Math.min(B, R) + 1);
	}
}