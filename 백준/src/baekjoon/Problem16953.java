package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16953
 */
public class Problem16953 {

	public static final long MAX_SIZE = 1_000_000_001;
	private static int count = Integer.MAX_VALUE;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		isVisited = new boolean[(int) MAX_SIZE];

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		search(A, B);

		if (count == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(count + 1);
	}

	private static void search(long a, long b) {
		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.count - n2.count);
		isVisited[(int) a] = true;
		queue.add(new Node(a, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			long cv = cur.value;

			if (cv > b) {
				continue;
			}

			if (cv == b) {
				count = Math.min(cur.count, count);
				break;
			}

			long next = 2 * cv;
			if (next < MAX_SIZE && !isVisited[(int) next]) {
				isVisited[(int) next] = true;
				queue.add(new Node(next, cur.count + 1));
			}

			next = 10 * cv + 1;
			if (next < MAX_SIZE && !isVisited[(int) next]) {
				isVisited[(int) next] = true;
				queue.add(new Node(next, cur.count + 1));
			}
		}
	}

	private static class Node {
		long value;
		int count;

		public Node(long value, int count) {
			this.value = value;
			this.count = count;
		}
	}
}
