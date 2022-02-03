package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1074
 */
public class Problem1074 {

	private static int count = 0;
	private static int answer = 0;
	private static int size;
	private static int r;
	private static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		size = (int) Math.pow(2, N);

		split(0, 0);

		System.out.println(answer);
	}

	private static void split(int x, int y) {

		if (size == 2) {
			for (int i = x; i < x + 2; i++) {
				for (int j = y; j < y + 2; j++) {
					if (i == r && j == c) {
						answer = count;
					}
					count++;
				}
			}
			return;
		}
		/**
		 * 2^3 = 8 -> 8*8 = 64
		 * 1 -> 0
		 * 2 -> 16
		 * 3 -> 32
		 * 4 -> 48
		 */
		int position = findPosition(r, c);
		int step = size * size / 4;
		size /= 2;

		switch (position) {

			case 1:
				count += step * 0;
				break;

			case 2:
				count += step * 1;
				c -= size;
				break;

			case 3:
				count += step * 2;
				r -= size;
				break;

			case 4:
				count += step * 3;
				r -= size;
				c -= size;
				break;
		}

		split(x, y);
	}

	private static int findPosition(int r, int c) {
		if ((r >= 0 && r < size / 2) && (c >= 0 && c < size / 2)) {
			return 1;
		}

		if ((r >= 0 && r < size / 2) && (c >= size / 2 && c < size)) {
			return 2;
		}

		if ((r >= size / 2 && r < size) && (c >= 0 && c < size / 2)) {
			return 3;
		}

		return 4;
	}
}
