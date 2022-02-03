package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1074
 */
public class Problem1074 {

	private static int[][] array;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N);

		array = new int[size][size];

		split(0, 0, size);

		System.out.println(array[r][c]);
	}

	private static void split(int x, int y, int size) {

		if (size == 2) {
			for (int i = x; i < x + 2; i++) {
				for (int j = y; j < y + 2; j++) {
					array[i][j] = count++;
				}
			}
			return;
		}
		size /= 2;
		split(x, y, size);
		split(x, y + size, size);
		split(x + size, y, size);
		split(x + size, y + size, size);

	}
}
