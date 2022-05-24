package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1922
 */
public class Problem1922 {

	private static PriorityQueue<Node> pq;
	private static int[] parent;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st;
		pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			pq.add(new Node(from, to, weight));
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int count = 0;
		while (!pq.isEmpty() || count != N - 1) {
			Node node = pq.poll();

			if (!isUnion(node.from, node.to)) {
				count++;
				answer += node.weight;
				union(node.from, node.to);
			}
		}

		System.out.println(answer);
	}

	private static boolean isUnion(int a, int b) {
		a = getParent(a);
		b = getParent(b);

		return a == b;
	}

	private static void union(int a, int b) {
		a = getParent(a);
		b = getParent(b);

		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int getParent(int child) {
		if (parent[child] == child) {
			return child;
		}
		return parent[child] = getParent(parent[child]);
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
