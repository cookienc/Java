package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2533
 */
public class Problem2533 {

	private static int N;
	private static int[][] dp;
	private static List<List<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N][2];

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<>());
		}
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			list.get(from).add(to);
			list.get(to).add(from);
		}

		dfs(0, -1);
		System.out.println(Math.min(dp[0][0], dp[0][1]));
	}

	private static void dfs(int cur, int parent) {
		dp[cur][0] = 0; // 얼리 어답터가 아닌 경우
		dp[cur][1] = 1; // 얼리 어답터인 경우

		for (Integer next : list.get(cur)) {
			if (next != parent) {
				dfs(next, cur);
				dp[cur][0] += dp[next][1];
				dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}
}
