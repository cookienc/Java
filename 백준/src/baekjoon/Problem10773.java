package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 출처: https://www.acmicpc.net/problem/10773
 */
public class Problem10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(bf.readLine());

		Stack<Long> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			Long item = Long.parseLong(bf.readLine());
			if (item == 0) {
				stack.pop();
				continue;
			}
			stack.push(item);
		}

		Long sum = stack.stream()
				.reduce(0L, Long::sum);

		System.out.println(sum);
	}
}
