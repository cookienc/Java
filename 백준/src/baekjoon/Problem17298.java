package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/17298
 * 참고: https://st-lab.tistory.com/196
 */
public class Problem17298 {

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] value = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && value[stack.peek()] < value[i]) {
				value[stack.pop()] = value[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			value[stack.pop()] = -1;
		}

		for (int i : value) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
