package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/3085
 */
public class Problem3085 {

	private static char[][] array;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(bufferedReader.readLine());

		array = new char[N][N];

		String temp;
		for (int i = 0; i < N; i++) {

			temp = bufferedReader.readLine();

			for (int j = 0; j < N; j++) {
				array[i][j] = temp.charAt(j);
			}
		}

		int max = getMax();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				char criteria = array[i][j];
				for (int k = 0; k < 4; k++) {

					int nextRow = i + dx[k];
					int nextColumn = j + dy[k];

					if (isItRange(nextRow, nextColumn)) {
						if (criteria != array[nextRow][nextColumn]) {
							swap(i, j, nextRow, nextColumn);
							max = Math.max(max, getMax());
							swap(i, j, nextRow, nextColumn);
						}
					}
				}
			}
		}
		System.out.println(max);
	}

	private static void swap(int i, int j, int nextRow, int nextColumn) {
		char temp = array[i][j];
		array[i][j] = array[nextRow][nextColumn];
		array[nextRow][nextColumn] = temp;
	}

	private static int getMax() {

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				char criteria = array[i][j];
				int count = 1;

				//우
				if (j < N) {
					for (int k = j + 1; k < N; k++) {
						if (array[i][k] != criteria) {
							break;
						}
						count++;
					}
				}
				max = Math.max(max, count);
				count = 1;

				if (i < N) {
					//하
					for (int k = i + 1; k < N; k++) {
						if (array[k][j] != criteria) {
							break;
						}
						count++;
					}
				}

				max = Math.max(max, count);
			}
		}

		return max;
	}

	private static boolean isItRange(int nextRow, int nextColumn) {
		return !((nextRow < 0 || nextRow >= N) || (nextColumn < 0 || nextColumn >= N));
	}
}
