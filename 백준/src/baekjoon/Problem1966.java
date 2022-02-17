package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1966
 */
public class Problem1966 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());

		Queue<int[]> queue = new LinkedList<>(); //int[] -> {순서, 중요도}

		StringTokenizer st;
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			queue.clear();
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				queue.offer(new int[]{j, Integer.parseInt(st.nextToken())});
			}

			int count = 0;
			while (true) {
				int[] tmp = queue.poll();

				if (queue.stream()
						.anyMatch(array -> array[1] > tmp[1])) {
					queue.offer(tmp);
					continue;
				}
				count++;

				if (tmp[0] == M) {
					break;
				}
			}
			sb.append(count)
					.append(NEW_LINE);
		}

		System.out.println(sb);
	}
}
