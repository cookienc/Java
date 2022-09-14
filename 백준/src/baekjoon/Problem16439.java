package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16439
 */
public class Problem16439 {

	private static int[][] like;
	private static int M;
	private static int N;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		like = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combination(0, 0, 0);
		System.out.println(max);
	}

	private static void combination(int cnt, int start, int flag) {
		if (cnt > 3) {
			return;
		}

		if (cnt == 3) {
			int sum = 0;
			for (int m = 0; m < N; m++) {
				int tmp = 0;
				for (int i = 0; i < M; i++) {
					if ((flag & 1 << i) == 0) {
						continue;
					}
					tmp = Math.max(tmp, like[m][i]);
				}
				sum += tmp;
			}
			max = Math.max(sum, max);
		}

		for (int i = start; i < M; i++) {
			if ((flag & 1 << i) != 0) {
				continue;
			}
			combination(cnt + 1, i, flag | 1 << i);
		}
	}
}
