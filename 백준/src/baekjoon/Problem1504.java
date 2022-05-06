package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/1504
 */
public class Problem1504 {

	private static List<List<Node>> graph;
	private static int[][] distance;
	private static int N;
	private static int v1;
	private static int v2;
	private static final int INF = 200_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		initializeGraph(br, N, E);
		distance = new int[3][N];

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken()) - 1;
		v2 = Integer.parseInt(st.nextToken()) - 1;

		dijkstra(0, distance[0]);
		dijkstra(v1, distance[1]);
		dijkstra(v2, distance[2]);

		long min = Math.min(distance[0][v1] + distance[1][v2] + distance[2][N - 1],
				distance[0][v2] + distance[2][v1] + distance[1][N - 1]);

		if (min >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

	private static void dijkstra(int start, int[] distance) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
		boolean[] isVisited = new boolean[N];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int u = cur.v;

			if (isVisited[u]) {
				continue;
			}

			if (distance[u] < cur.weight) {
				continue;
			}

			isVisited[u] = true;

			for (Node node : graph.get(u)) {
				int v = node.v;

				if (distance[v] > distance[u] + node.weight) {
					distance[v] = distance[u] + node.weight;
					pq.add(new Node(v, distance[v]));
				}
			}
		}
	}

	private static void initializeGraph(BufferedReader br, int N, int E) throws IOException {
		StringTokenizer st;
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
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
