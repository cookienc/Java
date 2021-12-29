package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2740
 */
public class Problem2740 {

	private static int[][] a;
	private static int[][] b;
	private static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		a = new int[n][m];

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int l = Integer.parseInt(stringTokenizer.nextToken());
		int k = Integer.parseInt(stringTokenizer.nextToken());

		b = new int[l][k];

		for (int i = 0; i < l; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < k; j++) {
				b[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		result = new int[n][k];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				for (int o = 0; o < m; o++) {
					result[i][j] += a[i][o] * b[o][j];
				}
			}
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (int[] i : result) {
			for (int j : i) {
				stringBuilder.append(j)
						.append(" ");
			}
			stringBuilder.append("\n");
		}

		System.out.println(stringBuilder);
	}
}
