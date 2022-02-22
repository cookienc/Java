package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 출처: https://www.acmicpc.net/problem/1927
 */
public class Problem1927 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";
	public static final String ZERO = "0";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(bf.readLine());
			if (value == 0) {
				if (queue.isEmpty()) {
					sb.append(ZERO)
							.append(NEW_LINE);
					continue;
				}
				sb.append(queue.poll())
						.append(NEW_LINE);
				continue;
			}
			queue.offer(value);
		}

		System.out.println(sb);
	}
}
