package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11404
 */
public class Problem11404 {

	private static int[][] map;
	private static int[][] arr;
	private static int INF = 10_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());

			if (map[from][to] > weight) {
				map[from][to] = weight;
			}
		}

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.copyOf(map[i], N);
		}
		//k : 거쳐가는 점
		for (int k = 0; k < N; k++) {
			//i : 출발점
			for (int i = 0; i < N; i++) {
				//j : 도착점
				for (int j = 0; j < N; j++) {
					if (arr[i][k] + arr[k][j] < arr[i][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int[] array : arr) {
			for (int i : array) {
				if (i == INF) {
					sb.append(0).append(" ");
					continue;
				}
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
