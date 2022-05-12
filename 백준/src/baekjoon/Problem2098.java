package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2098
 */
public class Problem2098 {

	private static List<List<Node>> map;
	private static int[][] dp;
	private static int N;
	private static int start;
	private static int answer = Integer.MAX_VALUE;
	private static int INF = 11_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		initializeMap(N);
		inputData(br, N);

		dp = new int[N][(1 << N) - 1];

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], INF);
		}

		System.out.println(dfs(0, 1 << 0));

	}

	private static int dfs(int cur, int bit) {

		if (Integer.bitCount(bit) == N) {

			if (map.get(cur).get(0).cost == 0) {
				return INF;
			}

			return map.get(cur).get(0).cost;
		}

		if (dp[cur][bit] != INF) {
			return dp[cur][bit];
		}

		for (Node node : map.get(cur)) {

			int next = node.position;

			if ((bit & 1 << next) != 0 || node.cost == 0) {
				continue;
			}

			dp[cur][bit] = Math.min(dp[cur][bit], dfs(next, bit | 1 << next) + node.cost);
		}

		return dp[cur][bit];
	}

	private static void inputData(BufferedReader br, int N) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				map.get(i).add(new Node(j, cost));
			}
		}
	}

	private static void initializeMap(int N) {
		map = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			map.add(new LinkedList<>());
		}
	}

	private static class Node {
		int position;
		int cost;

		public Node(int position, int cost) {
			this.position = position;
			this.cost = cost;
		}
	}
}
