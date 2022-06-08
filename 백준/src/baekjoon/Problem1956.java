package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1956
 */
public class Problem1956 {

	private static int[][] edges;
	private static final int INF = 4_000_001;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		initialize(br, V, E);

		floydWarshall(V);

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {

				if (edges[i][j] == INF || edges[j][i] == INF ||
						edges[i][j] == 0 || edges[j][i] == 0) {
					continue;
				}

				min = Math.min(edges[i][j] + edges[j][i], min);
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

	private static void initialize(BufferedReader br, int V, int E) throws IOException {
		StringTokenizer st;
		edges = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i == j) {
					edges[i][j] = 0;
					continue;
				}
				edges[i][j] = INF;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			edges[u][v] = weight;
		}
	}

	private static void floydWarshall(int V) {
		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					if (edges[i][k] + edges[k][j] < edges[i][j]) {
						edges[i][j] = edges[i][k] + edges[k][j];
					}
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
