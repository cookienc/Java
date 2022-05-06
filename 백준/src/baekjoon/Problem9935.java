package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/9935
 */
public class Problem9935 {
	private static String origin;
	private static String bomb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine();
		bomb = br.readLine();

		int oriLen = origin.length();
		int bombLen = bomb.length();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < oriLen; i++) {

			stack.push(origin.charAt(i));
			// 맨 마지막이 같으면 앞으로 가면서 확인
			if (stack.size() >= bombLen) {
				boolean match = true;
				//bomb과 확인
				for (int j = 0; j < bombLen; j++) {
					//일치하지 않으면
					if (stack.get(stack.size() - 1 - j) != bomb.charAt(bombLen - 1 - j)) {
						match = false;
						break;
					}
				}

				if (match) {
					for (int j = 0; j < bombLen; j++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if(stack.size() == 0) {
			sb.append("FRULA");
		} else {
			for (Character c : stack) {
				sb.append(c);
			}
		}
		System.out.println(sb);
	}
}

