package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/1918
 * 참고: https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1918-%ED%9B%84%EC%9C%84-%ED%91%9C%EA%B8%B0%EC%8B%9D-JAVA%EC%9E%90%EB%B0%94
 */
public class Problem1918 {

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();

		Stack<Character> operator = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				sb.append(arr[i]);
				continue;
			}

			switch (arr[i]) {
				case '(':
					operator.push(arr[i]);
					break;
				case ')':
					while (!operator.isEmpty()) {
						Character pop = operator.pop();
						if (pop == '(') {
							break;
						}
						sb.append(pop);
					}
					break;
				case '*':
				case '/':
				case '+':
				case '-':
					while (!operator.isEmpty() && (rank(operator.peek()) >= rank(arr[i]))) {
						Character pop = operator.pop();
						if (pop == '(') {
							break;
						}
						sb.append(pop);
					}
					operator.push(arr[i]);
					break;
			}
		}

		while (!operator.isEmpty()) {
			sb.append(operator.pop());
		}
		System.out.println(sb);
	}

	private static int rank(Character op) {

		switch (op) {
			case '/':
			case '*':
				return 2;
			case '+':
			case '-':
				return 1;
		}

		return 0;
	}
}
