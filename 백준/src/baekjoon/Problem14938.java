package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14938
 */
public class Problem14938 {
	public static final int INF = 1501;
	private static int[] arr;
	private static List<List<Node>> nodes;
	private static int[] d;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		nodes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nodes.add(new ArrayList<>());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			nodes.get(u).add(new Node(v, w));
			nodes.get(v).add(new Node(u, w));
		}

		for (int i = 0; i < n; i++) {
			d = new int[n];
			Arrays.fill(d, INF);
			dijkstra(i);

			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (d[j] <= m) {
					sum += arr[j];	
				}
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

	private static void dijkstra(int start) {
		d[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (d[cur.v] < cur.weight) {
				continue;
			}

			for (Node next : nodes.get(cur.v)) {
				if (d[cur.v] + next.weight < d[next.v]) {
					d[next.v] = d[cur.v] + next.weight;
					pq.add(new Node(next.v, d[next.v]));
				}
			}
		}
	}

	private static class Node {
		int v;
		int weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
}
