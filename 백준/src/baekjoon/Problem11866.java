package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11866
 */
public class Problem11866 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String SEPARATOR = ", ";
	public static final String OPEN_BRACKET = "<";
	public static final String CLOSE_BRACKET = ">";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		sb.append(OPEN_BRACKET);
		while (queue.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				queue.offer(queue.poll());
			}
			sb.append(queue.poll())
					.append(SEPARATOR);
		}

		sb.append(queue.poll())
				.append(CLOSE_BRACKET);

		System.out.println(sb);
	}
}
