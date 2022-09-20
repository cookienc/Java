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
 * 출처: https://www.acmicpc.net/problem/1719
 */
public class Problem1719 {

	private static List<List<Node>> nodes;
	private static int[] route;
	private static int[] d;
	private static int n;
	private static int m;
	private static int INF = 200 * 1000 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nodes = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			nodes.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			nodes.get(u).add(new Node(v, w));
			nodes.get(v).add(new Node(u, w));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			d = new int[n + 1];
			route = new int[n + 1];
			dijkstra(i, sb);
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start, StringBuilder sb) {
		Arrays.fill(d, INF);
		Arrays.fill(route, -1);
		d[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (d[cur.next] < cur.weight) {
				continue;
			}

			for (Node next : nodes.get(cur.next)) {
				if (d[cur.next] + next.weight < d[next.next]) {
					route[next.next] = cur.next;
					d[next.next] = d[cur.next] + next.weight;
					pq.add(new Node(next.next, d[next.next]));
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (i == start) {
				sb.append("- ");
				continue;
			}
			sb.append(find(i, start) + " ");
		}
		sb.append("\n");
	}

	private static int find(int i, int start) {
		if (route[i] == start) {
			return i;
		}
		return find(route[i], start);
	}

	private static class Node {
		int next;
		int weight;

		public Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
	}
}
