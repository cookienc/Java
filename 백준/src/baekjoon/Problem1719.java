package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1719
 */
public class Problem1719 {

	private static int[][] arr;
	private static int[][] route;
	private static int n;
	private static int m;
	private static int INF = 200 * 1000 + 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		route = new int[n + 1][n + 1];

		for (int r = 1; r < n + 1; r++) {
			for (int c = 1; c < n + 1; c++) {
				if (r == c) {
					arr[r][c] = 0;
					continue;
				}
				arr[r][c] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[u][v] = Math.min(w, arr[u][v]);
			arr[v][u] = Math.min(w, arr[v][u]);
			route[u][v] = v;
			route[v][u] = u;
		}

		for (int k = 1; k < n + 1; k++) {
			for (int r = 1; r < n + 1; r++) {
				for (int c = 1; c < n + 1; c++) {
					if (arr[r][k] + arr[k][c] < arr[r][c]) {
						arr[r][c] = arr[r][k] + arr[k][c];
						route[r][c] = route[r][k];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r = 1; r < n + 1; r++) {
			for (int c = 1; c < n + 1; c++) {
				int value = route[r][c];
				if (value == 0) {
					sb.append("- ");
					continue;
				}
				sb.append(value + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
