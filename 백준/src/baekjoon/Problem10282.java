package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.*;

import static java.util.Comparator.*;

/**
 * 출처: https://www.acmicpc.net/problem/10282
 */
public class Problem10282 {

	private static final StringBuilder sb = new StringBuilder();
	private static List<List<Edge>> edges;
	private static int[] weight;
	private static final int INF = 1_000_000_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			initializeEdges(br, n, d);

			dijkstra(c);

			int count = 0;
			int max = -1;
			for (int i = 1; i <= n; i++) {
				if (weight[i] == INF) {
					continue;
				}
				count++;
				max = Math.max(max, weight[i]);
			}
			sb.append(count).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		weight[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>(comparingInt(e -> e.weight));
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			int current = cur.v;
			int curWeight = cur.weight;

			if (weight[current] < curWeight) {
				continue;
			}

			for (Edge next : edges.get(current)) {
				int nextWeight = weight[current] + next.weight;
				if (nextWeight < weight[next.v]) {
					weight[next.v] = nextWeight;
					pq.add(new Edge(next.v, weight[next.v]));
				}
			}
		}

	}

	private static void initializeEdges(BufferedReader br, int n, int d) throws IOException {
		StringTokenizer st;
		edges = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < d; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edges.get(v).add(new Edge(u, weight));
		}

		weight = new int[n + 1];
		Arrays.fill(weight, INF);
	}

	private static class Edge {
		int v;
		int weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
}
