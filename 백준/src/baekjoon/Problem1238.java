package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/1238
 */
public class Problem1238 {

	private static List<List<Node>> graph;
	private static final int INF = 987654321;
	private static int[][] distance;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;

		initializeGraph(br, N, M);

		int max = Integer.MIN_VALUE;
		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			dijkstra(i, distance[i]);
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum = distance[i][X] + distance[X][i];
//			System.out.println("index : " + i + " go : " + distance[i][X] + " to : " + distance[X][i] + " sum : " + sum);
			max = Math.max(max, sum);
		}

		System.out.println(max);
	}

	private static void dijkstra(int start, int[] distance) {
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.weight - n2.weight);
		boolean[] isVisited = new boolean[N + 1];
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			int u = cur.to;
			if (isVisited[u]) {
				continue;
			}

			if (distance[u] < cur.weight) {
				continue;
			}

			isVisited[u] = true;
			for (Node node : graph.get(u)) {
				int v = node.to;

				if (distance[v] > distance[u] + node.weight) {
					distance[v] = distance[u] + node.weight;
					pq.add(new Node(v, distance[v]));
				}
			}
		}
	}

	private static void initializeGraph(BufferedReader br, int N, int M) throws IOException {
		StringTokenizer st;
		graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Node(to, weight));
		}
	}

	private static class Node {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
}
