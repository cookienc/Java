package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2630
 */
public class Problem2630 {

	public static final boolean BLUE = true;
	private static boolean[][] array;
	private static int blue;
	private static int white;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		array = new boolean[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					array[i][j] = BLUE;
				}
			}
		}

		partition(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}

	private static void partition(int x, int y, int range) {

		if (isSameColor(x, y, range)) {
			if (array[x][y] == BLUE) {
				blue++;
				return;
			}
			white++;
			return;
		}

		int newRange = range / 2;

		partition(x, y, newRange);
		partition(x, y + newRange, newRange);
		partition(x + newRange, y, newRange);
		partition(x + newRange, y + newRange, newRange);
	}

	private static boolean isSameColor(int x, int y, int range) {

		boolean isSame = array[x][y];

		for (int i = x; i < x + range; i++) {
			for (int j = y; j < y + range; j++) {
				if (isSame != array[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
