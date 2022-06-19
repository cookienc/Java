package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1357
 */
public class Problem1357 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		System.out.println(rev(rev(X) + rev(Y)));
	}

	private static int rev(int x) {
		if (x >= 1000) {

			int first = x / 1000;
			x %= 1000;

			int second = x / 100;
			x %= 100;

			int third = x / 10;
			x %= 10;

			int fourth = x;

			return fourth * 1000 + third * 100 + second * 10 + first;
		}

		if (x >= 100) {
			int first = x / 100;
			x %= 100;

			int second = x / 10;
			x %= 10;

			int third = x;

			return third * 100 + second * 10 + first;
		}

		if (x >= 10) {

			int first = x / 10;
			x %= 10;

			int second = x;

			return second * 10 + first;
		}

		return x;
	}
}
