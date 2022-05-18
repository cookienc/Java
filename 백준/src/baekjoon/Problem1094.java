package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1094
 */
public class Problem1094 {

	private static final int origin = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());

		if (X == 64) {
			System.out.println(1);
			return;
		}

		int curStick = origin;
		int remain = 0;
		int total = 0;

		while (true) {

			curStick /= 2;
			total += 2;
			remain += curStick;
			total--;
			if (remain > X) {
				remain -= curStick;
				total--;
			} else if (remain == X) {
				break;
			}
		}

		System.out.println(total);
	}
}
