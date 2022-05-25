package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2493
 */
public class Problem2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i <= N; i++) {
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
					stack.pop();
				}

				if (stack.isEmpty()) {
					sb.append(0).append(" ");
				} else {
					sb.append(stack.peek()).append(" ");
				}
			}
			stack.push(i);
		}

		System.out.println(sb);
	}
}
