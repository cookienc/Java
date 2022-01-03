package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1107
 * 참고: https://moonsbeen.tistory.com/64
 */
public class Problem1107 {

	public static final int FIRST_POSITION = 100;
	private static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine());
		int m = Integer.parseInt(bufferedReader.readLine());

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 0; i < m; i++) {
			broken[Integer.parseInt(stringTokenizer.nextToken())] = true;
		}

		int click = Math.abs(n - FIRST_POSITION);

		for (int i = 0; i < 1000000; i++) {
			String s = String.valueOf(i);
			int length = s.length();

			boolean isBroken = false;

			for (int j = 0; j < length; j++) {
				if (broken[s.charAt(j) - '0']) {
					isBroken = true;
					break;
				}
			}

			if (!isBroken) {
				int min = Math.abs(n - i) + length;
				click = Math.min(min, click);
			}

		}
		System.out.println(click);

	}
}
