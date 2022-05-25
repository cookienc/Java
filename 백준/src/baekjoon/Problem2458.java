package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2458
 */
public class Problem2458 {

	private static int[][] map;
	private static final int INF = 250000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		initializeMap(br, N, M);

		floydWarshall(N);

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] == INF) {
					map[i][j] = 0;
				}
			}
		}

		int count = 0;

		for (int i = 1; i < N + 1; i++) {
			boolean canKnow = true;
			for (int j = 1; j < N + 1; j++) {
				if (i == j) {
					continue;
				}

				if (map[j][i] == 0 && map[i][j] == 0) {
					canKnow = false;
					break;
				}
			}

			if (canKnow) {
				count++;
			}
		}

		System.out.println(count);
	}

	private static void floydWarshall(int N) {
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}

	private static void initializeMap(BufferedReader br, int N, int M) throws IOException {
		StringTokenizer st;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i == j) {
					map[i][j] = 0;
					continue;
				}
				map[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			map[from][to] = 1;
		}
	}
}
