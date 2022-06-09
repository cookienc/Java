package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10159
 */
public class Problem10159 {

	public static final int INF = 101;
	private static int[][] edges;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		initialize(br, N, M);

		floydWarshall(N);

		for (int i = 0; i < N; i++) {
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				if (i == j) {
					continue;
				}

				if (edges[i][j] == INF && edges[j][i] == INF) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}

	private static void floydWarshall(int N) {
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (edges[i][j] > edges[i][k] + edges[k][j]) {
						edges[i][j] = 1;
					}
				}
			}
		}
	}

	private static void initialize(BufferedReader br, int N, int M) throws IOException {
		edges = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					edges[i][j] = 0;
					continue;
				}
				edges[i][j] = INF;
			}
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;

			edges[u][v] = 1;
		}
	}
}
