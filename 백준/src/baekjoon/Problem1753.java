package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/1753
 */
public class Problem1753 {

	public static final int INF = 987654321;
	public static final String NEW_LINE = "\n";
	private static List<List<Node>> weight;
	private static int[] array;
	private static boolean[] isVisited;
	private static int V;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(bf.readLine());
		weight = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			weight.add(new ArrayList<Node>());
		}
		array = new int[V + 1];
		isVisited = new boolean[V + 1];

		Arrays.fill(array, INF);
		array[start] = 0;

		for (int i = 1 ; i <= E; i++) {
			st = new StringTokenizer(bf.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			weight.get(u).add(new Node(v, w));
		}

		dijkstra(start);

		for (int i = 1; i <= V; i++) {
			if (array[i] == INF) {
				sb.append("INF")
						.append(NEW_LINE);
				continue;
			}
			sb.append(array[i])
					.append(NEW_LINE);
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>((l1, l2) -> (l1.distance - l2.distance));

		queue.offer(new Node(start, array[start]));

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int dot = current.dot;
			int distance = current.distance;

			if (isVisited[dot]) {
				continue;
			}
			isVisited[dot] = true;

			for (Node nextNode : weight.get(dot)) {
				int index = nextNode.dot;
				int lineWeight = distance + nextNode.distance;

				if (lineWeight < array[index]) {
					array[index] = lineWeight;
					queue.offer(new Node(index, array[index]));
				}
			}
		}
	}

	private static class Node {

		int dot;
		int distance;

		public Node(int dot, int distance) {
			this.dot = dot;
			this.distance = distance;
		}
	}

}
