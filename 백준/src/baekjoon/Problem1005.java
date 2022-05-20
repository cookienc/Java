package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/1005
 */
public class Problem1005 {

	private static int[] cost;
	private static int[] buildingCost;
	private static int[] connected;
	private static boolean[] isVisited;
	private static List<List<Integer>> list;
	private static int N;
	private static int K;
	private static int W;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		while (T-- > 0) {
			initialize(br);
			topologicalSort();
		}

		System.out.println(sb);
	}

	private static void topologicalSort() {
		Queue<Node> queue = new LinkedList<>();
		buildingCost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (connected[i] == 0) {
				buildingCost[i] = cost[i];
				queue.add(new Node(i, 0));
			}
		}

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			int current = cur.index;
			if (W == current) {
				sb.append(buildingCost[W]).append("\n");
				break;
			}

			for (Integer next : list.get(current)) {
				connected[next]--;
				buildingCost[next] = Math.max(buildingCost[current] + cost[next], buildingCost[next]);
				if (connected[next] == 0) {
					queue.add(new Node(next, cur.count + 1));
				}
			}
		}
	}

	private static class Node {
		int index;
		int count;

		public Node(int index, int count) {
			this.index = index;
			this.count = count;
		}
	}

	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		cost = new int[N + 1];
		connected = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			connected[after]++;
			list.get(before).add(after);
		}

		W = Integer.parseInt(br.readLine());
	}
}
