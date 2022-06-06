package baekjoon;

import java.io.*;
import java.util.*;

import static java.util.Comparator.*;

/**
 * 출처: https://www.acmicpc.net/problem/11779
 */
public class Problem11779 {

	private static List<List<Edge>> edges;
	private static int[] route;
	private static int[] weight;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		edges = new ArrayList<>();
		route = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			edges.add(new ArrayList<>());
			route[i] = i;
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edges.get(u).add(new Edge(v, weight));
		}

		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		weight = new int[N + 1];
		Arrays.fill(weight, 1_000_000_001);
		dijkstra(u);

		bw.write(weight[v] + "\n");

		int count = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		while (route[v] != v || v == 0) {
			count += 1;
			stack.push(route[v]);
			v = route[v];
		}
		bw.write((count + 1) + "\n");
		while (!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}
		bw.flush();
		br.close();
		bw.close();
	}

	private static void dijkstra(int start) {
		weight[start] = 0;

		PriorityQueue<Edge> pq = new PriorityQueue<>(comparingInt(e -> e.weight));
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			int u = cur.v;

			if (weight[u] < cur.weight) {
				continue;
			}

			for (Edge edge : edges.get(u)) {
				int v = edge.v;
				int nextWeight = edge.weight;

				if (cur.weight + nextWeight < weight[v]) {
					weight[v] = cur.weight + nextWeight;
					route[v] = u;
					pq.add(new Edge(v, weight[v]));
				}
			}
		}
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
