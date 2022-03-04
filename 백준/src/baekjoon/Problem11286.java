package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 출처: https://www.acmicpc.net/problem/11286
 */
public class Problem11286 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
				(i1, i2) -> {

				int a = Math.abs(i1);
				int b = Math.abs(i2);

			if (a == b) {
				return i1 - i2;
			}

			return a - b;
		});

		while (N-- > 0) {
			int command = Integer.parseInt(bf.readLine());
			
			if (command == 0) {
				zeroOperation(queue);
				continue;
			}
			queue.offer(command);
		}

		System.out.println(sb);
	}

	private static void zeroOperation(PriorityQueue<Integer> queue) {
		if (queue.isEmpty()) {
			sb.append(0)
					.append(NEW_LINE);
			return;
		}
		sb.append(queue.poll())
				.append(NEW_LINE);
	}
}
