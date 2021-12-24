package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1992
 */
public class Problem1992 {

	private static int[][] array;
	private static StringBuilder stringBuilder;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		array = new int[n][n];

		for (int i = 0; i < n; i++) {
			String temp = bufferedReader.readLine();
			for (int j = 0; j < n; j++) {
				array[i][j] = temp.charAt(j) - '0';
			}
		}

		stringBuilder = new StringBuilder();
		quadTree(0, 0, n);
		System.out.println(stringBuilder);
	}

	private static void quadTree(int x, int y, int size) {

		if (isPossible(x, y, size)) {
			stringBuilder.append(array[x][y]);
			return;
		}

		int newSize = size / 2;
		stringBuilder.append("(");

		quadTree(x, y, newSize);
		quadTree(x, y + newSize, newSize);
		quadTree(x + newSize, y, newSize);
		quadTree(x + newSize, y + newSize, newSize);

		stringBuilder.append(")");
	}

	private static boolean isPossible(int x, int y, int size) {

		int check = array[x][y];

		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (check != array[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
