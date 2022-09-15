package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14391
 */
public class Problem14391 {
	private static int R;
	private static int C;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[R][C];

		for (int r = 0; r < R; r++) {
			String s = br.readLine();
			for (int c = 0; c < C; c++) {
				arr[r][c] = s.charAt(c) - '0';
			}
		}
		// 0은 가로 , 1은 세로
		int answer = 0;
		for (int flag = 0; flag < (1 << (R * C)); flag++) {
			int value = 0;
			// 가로
			for (int r = 0; r < R; r++) {
				int horizon = 0;
				for (int c = 0; c < C; c++) {
					if ((flag & (1 << (r * C + c))) == 0) {
						horizon *= 10;
						horizon += arr[r][c];
					} else {
						value += horizon;
						horizon = 0;
					}
				}
				value += horizon;
			}

			for (int c = 0; c < C; c++) {
				int vertical = 0;
				for (int r = 0; r < R; r++) {
					if ((flag & (1 << (r * C + c))) != 0) {
						vertical *= 10;
						vertical += arr[r][c];
					} else {
						value += vertical;
						vertical = 0;
					}
				}
				value += vertical;
			}
			answer = Math.max(answer, value);
		}
		System.out.println(answer);
	}
}
