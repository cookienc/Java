package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/3584
 */
public class Problem3584 {

	private static List<List<Integer>> edges;
	private static boolean[] isVisited;
	private static String aList = "";
	private static String bList = "";
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			edges = new ArrayList<>();
			initialize(br);

			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			isVisited = new boolean[N + 1];
			dfs(A, String.valueOf(A), true);
			isVisited = new boolean[N + 1];
			dfs(B, String.valueOf(B), false);

			String[] a = aList.split(",");
			String[] b = bList.split(",");

			if (a.length < b.length) {
				List<String> tmp = List.of(a);
				for (int i = 0; i < b.length; i++) {
					if (tmp.contains(b[i])) {
						sb.append(b[i]).append("\n");
						break;
					}
				}
			} else {
				List<String> tmp = List.of(b);
				for (int i = 0; i < a.length; i++) {
					if (tmp.contains(a[i])) {
						sb.append(a[i]).append("\n");
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}

	private static void dfs(int v, String order, boolean type) {

		if (edges.get(v).isEmpty()) {
			if (type) {
				aList = order;
				return;
			}

			bList = order;
			return;
		}

		for (Integer i : edges.get(v)) {
			if (isVisited[i]) {
				return;
			}

			isVisited[i] = true;
			dfs(i, order + "," + i, type);
			isVisited[i] = false;
		}
	}

	private static void initialize(BufferedReader br) throws IOException {
		StringTokenizer st;

		for (int i = 0; i <= N; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			edges.get(to).add(from);
		}
	}
}
