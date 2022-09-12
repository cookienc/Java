package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/20924
 */
public class Problem20924 {

	private static List<List<Node>> list;
	private static boolean[] isVisited;
	private static int trunk;
	private static int branch;
	private static int giga;
	private static int R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			list.get(a).add(new Node(b, d));
			list.get(b).add(new Node(a, d));
		}

		isVisited = new boolean[N + 1];
		findTrunk(R);
		findBranch(giga, 0);

		System.out.println(trunk + " " + branch);
	}

	private static void findBranch(int u, int sum) {
		if (list.get(u).size() == 1) {
			branch = Math.max(sum, branch);
			return;
		}

		isVisited[u] = true;

		for (Node n : list.get(u)) {
			int v = n.v;
			if (isVisited[v]) {
				continue;
			}

			isVisited[v] = true;
			findBranch(v, sum + n.weight);
			isVisited[v] = false;
		}

	}

	private static void findTrunk(int u) {
		int size = list.get(u).size();
		if (size >= 2) {
			for (Node node : list.get(u)) {
				if (isVisited[node.v]) {
					size--;
				}
			}

			if (size >= 2) {
				giga = u;
				return;
			}
		}

		isVisited[u] = true;
		for (Node n : list.get(u)) {
			int v = n.v;
			if (isVisited[v]) {
				continue;
			}

			isVisited[v] = true;
			trunk += n.weight;
			findTrunk(v);
			isVisited[v] = false;
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
