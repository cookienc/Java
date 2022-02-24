package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

import static java.util.Comparator.reverseOrder;

/**
 * 출처: https://www.acmicpc.net/problem/11279
 */
public class Problem11279 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";
	public static final String ZERO = "0";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<>(reverseOrder());
		while (N-- > 0) {
			int num = Integer.parseInt(bf.readLine());

			if (num == 0) {
				if (!queue.isEmpty()) {
					sb.append(queue.poll())
							.append(NEW_LINE);
				} else {
					sb.append(ZERO)
							.append(NEW_LINE);
				}
				continue;
			}
			queue.offer(num);
		}
		System.out.println(sb);
	}
}
