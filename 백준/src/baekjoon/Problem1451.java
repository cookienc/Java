package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1451
 * 참고: https://log-laboratory.tistory.com/128
 */
public class Problem1451 {

	private static int[][] rectangle;
	private static long[][] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());

		rectangle = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String temp = bufferedReader.readLine();
			for (int j = 1; j <= m; j++) {
				rectangle[i][j] = temp.charAt(j - 1) - '0';
			}
		}

		sum = new long[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (long) rectangle[i][j];
			}
		}


		long ans = 0;
		for (int i = 1; i <= m - 2; i++) {
			for (int j = i + 1; j <= m - 1; j++) {
				long r1 = sum(1, 1, n, i);
				long r2 = sum(1, i + 1, n, j);
				long r3 = sum(1, j + 1, n, m);
				if (ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
			}
		}

		for (int i = 1; i <= n - 2; i++) {
			for (int j = i + 1; j <= n - 1; j++) {
				long r1 = sum(1, 1, i, m);
				long r2 = sum(i + 1, 1, j, m);
				long r3 = sum(j + 1, 1, n, m);
				if (ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
			}
		}

		for (int i = 1; i <= n - 1; i++) {
			for (int j = 1; j <= m - 1; j++) {
				long r1 = sum(1, 1, n, j);
				long r2 = sum(1, j + 1, i, m);
				long r3 = sum(i + 1, j + 1, n, m);
				if (ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
				r1 = sum(1, 1, i, j);
				r2 = sum(i + 1, 1, n, j);
				r3 = sum(1, j + 1, n, m);
				if (ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
				r1 = sum(1, 1, i, m);
				r2 = sum(i + 1, 1, n, j);
				r3 = sum(i + 1, j + 1, n, m);
				if (ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
				r1 = sum(1, 1, i, j);
				r2 = sum(1, j + 1, i, m);
				r3 = sum(i + 1, 1, n, m);
				if (ans < r1 * r2 * r3) {
					ans = r1 * r2 * r3;
				}
			}
		}
		System.out.println(ans);
	}

	private static long sum(int x1, int y1, int x2, int y2) {
		return sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
	}
}
