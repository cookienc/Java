package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/16507
 */
public class Problem16507 {

	private static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		initialize(br, R, C);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= Q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			sb.append(calculate(r1, c1, r2, c2)).append("\n");
		}
		System.out.println(sb);
	}

	private static int calculate(int r1, int c1, int r2, int c2) {
		return (arr[r2][c2] - arr[r1 - 1][c2] - arr[r2][c1 - 1] + arr[r1 - 1][c1 - 1]) /
				((r2 - r1 + 1) * (c2 - c1 + 1));
	}

	private static void initialize(BufferedReader br, int R, int C) throws IOException {
		arr = new int[R + 1][C + 1];
		StringTokenizer st;
		for (int r = 1; r <= R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= C; c++) {
				arr[r][c] = arr[r][c - 1] + Integer.parseInt(st.nextToken());
			}
		}

		for (int c = 1; c <= C; c++) {
			for (int r = 1; r <= R; r++) {
				arr[r][c] += arr[r - 1][c];
			}
		}
	}
}
