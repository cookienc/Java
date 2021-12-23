package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2447
 * 참고: https://st-lab.tistory.com/95
 */
public class Problem2447 {

	private static char[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();

		int n = Integer.parseInt(bufferedReader.readLine());

		array = new char[n][n];

		makeStar(0, 0, n, false);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				stringBuilder.append(array[i][j]);
			}
			stringBuilder.append("\n");
		}
		System.out.println(stringBuilder);
	}

	private static void makeStar(int x, int y, int n, boolean isBlank) {

		if (isBlank) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					array[i][j] = ' ';
				}
			}
			return;
		}

		if (n == 1) {
			array[x][y] = '*';
			return;
		}

		int size = n / 3;
		int count = 0;
		for (int i = x; i < x + n; i += size) {
			for (int j = y; j < y + n; j += size) {
				count++;
				if (count == 5) {
					makeStar(i, j, size, true);
				} else {
					makeStar(i, j, size, false);
				}
			}
		}
	}
}
