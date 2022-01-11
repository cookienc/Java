package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1018
 */
public class Problem1018 {

	public static final boolean BLACK = true;
	public static final boolean WHITE = false;
	private static boolean[][] array;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());

		array = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = bufferedReader.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'B') {
					array[i][j] = BLACK;
					continue;
				}
				array[i][j] = WHITE;
			}
		}

		int rowRange = N - 7;
		int columnRange = M - 7;

		for (int i = 0; i < rowRange; i++) {
			for (int j = 0; j < columnRange; j++) {
				min = Math.min(min, count(i, j));
			}
		}

		System.out.println(min);

	}

	private static int count(int row, int column) {
		int endRow = row + 8;
		int endColumn = column + 8;

		int bw = 0;
		int wb = 0;

		boolean standard = BLACK;

		for (int i = row; i < endRow; i++) {
			for (int j = column; j < endColumn; j++) {
				if (array[i][j] != standard) {
					bw++;
				}
				standard = !standard;
			}
			standard = !standard;
		}

		standard = WHITE;

		for (int i = row; i < endRow; i++) {
			for (int j = column; j < endColumn; j++) {
				if (array[i][j] != standard) {
					wb++;
				}
				standard = !standard;
			}
			standard = !standard;
		}

		return Math.min(bw, wb);
	}
}
