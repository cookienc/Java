package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1058
 */
public class Problem1058 {

	private static final int INF = 100;
	private static int[][] info;
	private static int[][] distance;
	private static int max = Integer.MIN_VALUE;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		input(br);

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (k == i || k == j || i == j) {
						continue;
					}

					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
					}
				}
			}
		}

		find2Friend();
		System.out.println(max);
	}

	private static void find2Friend() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if ((distance[i][j] == 0 || distance[i][j] == INF) &&
						(info[i][j] == 0 || info[i][j] == INF)) {
					continue;
				}

				if (distance[i][j] <= 2) {
					sum++;
				}
			}

			max = Math.max(max, sum);
		}
	}

	private static void input(BufferedReader br) throws IOException {
		info = new int[N][N];
		distance = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {

				if (i == j) {
					info[i][j] = 0;
					distance[i][j] = 0;
					continue;
				}

				if (chars[j] == 'N') {
					info[i][j] = INF;
					distance[i][j] = INF;
					continue;
				}
				info[i][j] = 1;
				distance[i][j] = 1;
			}
		}
	}
}
