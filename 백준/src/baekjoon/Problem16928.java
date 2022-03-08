package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16928
 */
public class Problem16928 {

	private static Map<Integer, Integer> map = new HashMap<>();
	private static boolean[] isVisited = new boolean[101];
	private static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int total = N + M;
		while (total-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map.put(from, to);
		}
		isVisited[0] = true;

		bfs();

		System.out.println(answer);
	}

	private static void bfs() {
		PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> (n1.count - n2.count));
		queue.offer(new Node(1, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int curPosition = node.position;
			int curCount = node.count;

			if (map.containsKey(curPosition)) {
				curPosition = map.get(curPosition);
				isVisited[curPosition] = true;
			}

			if (curPosition == 100) {
				answer = Math.min(answer, curCount);
				return;
			}

			for (int i = 1; i <= 6; i++) {
				int nextPosition = curPosition + i;
				if (nextPosition > 100) {
					continue;
				}

				if (isVisited[nextPosition]) {
					continue;
				}

				isVisited[nextPosition] = true;
				if (nextPosition == 100) {
					isVisited[100] = false;
				}
				queue.offer(new Node(nextPosition, curCount + 1));
			}
		}
	}

	private static class Node {
		int position;
		int count;

		public Node(int position, int count) {
			this.position = position;
			this.count = count;
		}
	}
}
