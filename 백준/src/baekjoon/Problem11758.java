package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11758
 */
public class Problem11758 {

	private static int X = 0;
	private static int Y = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[][] p = new int[4][2]; // 1, 2, 3 | x, y
		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			p[i][0] = Integer.parseInt(st.nextToken());
			p[i][1] = Integer.parseInt(st.nextToken());
		}

		System.out.println(find(p));
	}

	private static int find(int[][] p) {
		int flag = (p[2][X] * p[1][Y] + p[3][X] * p[2][Y] + p[1][X] * p[3][Y]) -
				(p[1][X] * p[2][Y] + p[2][X] * p[3][Y] + p[3][X] * p[1][Y]);

		if (flag > 0) {
			return -1;
		}

		if (flag == 0) {
			return 0;
		}

		return 1;
	}
}
