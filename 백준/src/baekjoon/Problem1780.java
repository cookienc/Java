package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1780
 */
public class Problem1780 {

	private static int[][] array;
	private static int[] countNumber;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());

		array = new int[n][n];

		StringTokenizer stringTokenizer;

		for (int i = 0; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < n; j++) {
				array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		/**
		 * countNumber[0] : -1의 개수
		 * countNumber[1] : 0의 개수
		 * countNumber[2] : 1의 개수
		 */
		countNumber = new int[3];
		dividePaper(0, 0, n);

		for (int i : countNumber) {
			System.out.println(i);
		}
	}

	private static void dividePaper(int x, int y, int size) {
		if (isPossible(x, y, size)) {
			countNumber[array[x][y] + 1]++;
			return;
		}

		int newSize = size / 3;

		dividePaper(x, y, newSize);
		dividePaper(x, y + newSize, newSize);
		dividePaper(x, y + 2 * newSize, newSize);

		dividePaper(x + newSize, y, newSize);
		dividePaper(x + newSize, y + newSize, newSize);
		dividePaper(x + newSize, y + 2 * newSize, newSize);

		dividePaper(x + 2 * newSize, y, newSize);
		dividePaper(x + 2 * newSize, y + newSize, newSize);
		dividePaper(x + 2 * newSize, y + 2 * newSize, newSize);
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
