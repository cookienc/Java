package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1197
 */
public class Problem1197 {

	private static int V;
	private static int E;
	private static int[] parent;
	private static PriorityQueue<Node> queue;
	private static int sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
		initialize(br);

		parent = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parent[i] = i;
		}
		MST();
		System.out.println(sum);
	}

	private static int getParent(int[] parent, int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = getParent(parent, parent[x]);
	}

	private static void union(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static boolean findParent(int[] parent, int a, int b) {
		a = getParent(parent, a);
		b = getParent(parent, b);

		return a == b;
	}
	private static void MST() {
		int count = 0;

		while (!queue.isEmpty() || count != V - 1) {
			Node node = queue.poll();
			if (!findParent(parent, node.from, node.to)) {
				count++;
				sum += node.weight;
				union(parent, node.from, node.to);
			}
		}

	}

	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			queue.add(new Node(from, to, weight));
		}
	}

	private static class Node {

		int from;
		int to;
		int weight;

		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}
