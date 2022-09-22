package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		int high = max;
		Queue<Node> q = new LinkedList<>();
		boolean[] checked = new boolean[n + 1];

		while(low <= high) {
			int mid = low + (high - low) / 2;
			q.add(new Node(from, 0));
			checked[from] = true;

			if(existPossibleRoute(q, checked, mid, to)) {
				answer = Math.max(answer, mid);
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}

			q.clear();
			Arrays.fill(checked, false);
		}
	}

	static boolean existPossibleRoute(Queue<Node> q, boolean[] checked, int mid, int end) {
		while(!q.isEmpty()) {
			Node cur = q.poll();

			for(Node v : graph.get(cur.v)) {
				if(v.weight >= mid) {
					if(cur.v == end) {
						return true;
					}

					if(!checked[v.v]) {
						checked[v.v] = true;
						q.add(v);
					}
				}
			}
		}
		return false;
	}

	private static class Node {
		int v;
		int weight;

		Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
}