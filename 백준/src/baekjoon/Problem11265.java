package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11265
 */
public class Problem11265 {
	public static final int INF = 500 * 1_000_000_000;
	private static int N;
	private static long[][] edges;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		edges = new long[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (r == c) {
					edges[r][c] = 0;
				} else {
					edges[r][c] = INF;
				}
			}
		}

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				edges[r][c] = Long.parseLong(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (edges[r][i] + edges[i][c] <= edges[r][c]) {
						edges[r][c] = edges[r][i] + edges[i][c];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			int C = Integer.parseInt(st.nextToken());

			if (edges[A][B] <= C) {
				sb.append("Enjoy other party").append("\n");
				continue;
			}
			sb.append("Stay here").append("\n");
		}
		System.out.println(sb);
	}
}