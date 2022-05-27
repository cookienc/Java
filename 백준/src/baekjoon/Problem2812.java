package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2812
 */
public class Problem2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[] nums = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<>();
		for (char num : nums) {
			int n = num - '0';
			if (stack.isEmpty()) {
				stack.push(n);
				continue;
			}

			while (K > 0 && !stack.isEmpty() && stack.peek() < n) {
				K--;
				stack.pop();
			}

			stack.push(n);
		}
		while (K-- > 0) {
			stack.pop();
		}

		StringBuilder sb = new StringBuilder();
		for (Integer integer : stack) {
			sb.append(integer);
		}
		System.out.println(sb);
	}
}

