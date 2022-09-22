package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1939
 */
public class Problem1939 {
	private static List<List<Node>> graph;
	private static int answer;
	private static int max;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();

		for(int i = 1; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, weight));
			graph.get(to).add(new Node(from, weight));
			max = Math.max(max, weight);
		}

		// 공장 찾기
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken()) - 1;
		int to = Integer.parseInt(st.nextToken()) - 1;

		findMaxWeight(n, from, to);
		System.out.println(answer);
	}

	static void findMaxWeight(int n, int from, int to) {

		int low = 0;
		int high = max + 1;
		boolean[] checked = new boolean[n + 1];

		while(low + 1 < high) {
			int mid = low + (high - low) / 2;
			checked[from] = true;

			if(existPossibleRoute(from, to, mid, checked)) {
				answer = Math.max(answer, mid);
				low = mid;
			}
			else {
				high = mid;
			}

			Arrays.fill(checked, false);
		}
	}

	static boolean existPossibleRoute(int u, int v, int mid, boolean[] checked) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(u, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			for(Node next : graph.get(cur.v)) {
				if(next.weight >= mid) {
					if(cur.v == v) {
						return true;
					}

					if(!checked[next.v]) {
						checked[next.v] = true;
						pq.add(next);
					}
				}
			}
		}
		return false;
	}

	private static class Node implements Comparable<Node> {

		int v;
		int weight;

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return o.weight - this.weight;
		}
	}
}