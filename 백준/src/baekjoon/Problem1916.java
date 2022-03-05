package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/1916
 */
public class Problem1916 {

	public static final int INF = Integer.MAX_VALUE;
	private static List<List<Node>> list;
	private static boolean[] isVisited;
	private static int[] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());

		list = new ArrayList<>();
		isVisited = new boolean[N + 1];
		weight = new int[N + 1];

		initializeList(N);

		StringTokenizer st;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(bf.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(u).add(new Node(v, w));
		}

		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		initializeWeight(start);
		dijkstra(start);

		System.out.println(weight[end]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> node1.distance - node2.distance);
		queue.offer(new Node(start, weight[start]));

		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			int dot = currentNode.dot;
			int distance = currentNode.distance;

			if (isVisited[dot]) {
				continue;
			}
			isVisited[dot] = true;

			for (Node nextNode : list.get(dot)) {
				int index = nextNode.dot;
				int lineWeight = nextNode.distance + distance;

				if (lineWeight < weight[index]) {
					weight[index] = lineWeight;
					queue.offer(new Node(index, lineWeight));
				}
			}
		}
	}

	private static void initializeWeight(int start) {
		Arrays.fill(weight, INF);
		weight[start] = 0;
	}

	private static void initializeList(int N) {
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
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
