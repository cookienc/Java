package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1476
 */
public class Problem1476 {

	private static int e;
	private static int s;
	private static int m;
	private static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		e = Integer.parseInt(stringTokenizer.nextToken());
		s = Integer.parseInt(stringTokenizer.nextToken());
		m = Integer.parseInt(stringTokenizer.nextToken());

		int count = 0;
		int countE = 0;
		int countS = 0;
		int countM = 0;

		while (true) {
			count++;
			countE++;
			countS++;
			countM++;

			if (countE > 15) {
				countE = 1;
			}

			if (countS > 28) {
				countS = 1;
			}

			if (countM > 19) {
				countM = 1;
			}

			if (countS != s) {
				continue;
			}

			if (countM != m) {
				continue;
			}

			if (countE != e) {
				continue;
			}

			break;
		}

		System.out.println(count);
	}
}
