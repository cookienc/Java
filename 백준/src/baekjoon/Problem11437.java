package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11437
 */
public class Problem11437 {

	private static List<List<Integer>> edges;
	private static int[] depth;
	private static int[] parent;
	private static boolean[] isVisited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		edges = new ArrayList<>();
		depth = new int[N + 1];
		parent = new int[N + 1];
		isVisited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			edges.get(from).add(to);
			edges.get(to).add(from);
		}

		dfs(1, 0);

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			lca(a, b);
		}
		System.out.println(sb);
	}

	private static void lca(int a, int b) {
		while (depth[a] != depth[b]) {
			if (depth[a] < depth[b]) {
				b = parent[b];
			} else {
				a = parent[a];
			}
		}

		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		sb.append(a).append("\n");
	}

	private static void dfs(int v, int d) {
		isVisited[v] = true;
		depth[v] = d;

		for (Integer i : edges.get(v)) {
			if (isVisited[i]) {
				continue;
			}

			parent[i] = v;
			dfs(i, d + 1);
		}
	}
}
