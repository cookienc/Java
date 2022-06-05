package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Comparator.*;

/**
 * 출처: https://www.acmicpc.net/problem/18352
 */
public class Problem18352 {

	public static final int INF = 300_001;
	private static List<List<Node>> distance;
	private static int[] d;
	private static int N;
	private static int M;
	private static int K;
	private static int X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		distance = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			distance.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			distance.get(from).add(new Node(to, 1));
		}

		d = new int[N + 1];
		Arrays.fill(d, INF);

		dijkstra(X);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (d[i] == K) {
				sb.append(i).append("\n");
			}
		}

		if (sb.length() == 0) {
			sb.append(-1);
		}

		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		d[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(comparingInt(n -> n.cost));
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (d[cur.next] < cur.cost) {
				continue;
			}

			for (Node n : distance.get(cur.next)) {
				if (n.cost + d[cur.next] < d[n.next]) {
					d[n.next] = n.cost + d[cur.next];
					pq.add(new Node(n.next, d[n.next]));
				}
			}
		}
	}

	private static class Node {
		int next;
		int cost;

		public Node(int next, int cost) {
			this.next = next;
			this.cost = cost;
		}
	}
}
