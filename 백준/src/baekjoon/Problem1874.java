package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/1874
 */
public class Problem1874 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";
	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String NO = "NO";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] array = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(bf.readLine());
		}

		int start = 1;

		for (int i = 0; i < n; i++) {

			for (int j = start; j <= array[i]; j++) {
				stack.push(j);
				sb.append(PLUS)
						.append(NEW_LINE);
				start = j + 1;
			}

			while (true) {
				if (stack.peek() == array[i]) {
					stack.pop();
					sb.append(MINUS)
							.append(NEW_LINE);
					break;
				} else {
					System.out.println(NO);;
					System.exit(0);
				}
			}
		}

		System.out.println(sb);
	}
}
