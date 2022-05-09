package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/10162
 */
public class Problem10162 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int threeHundred = 0;
		int sixty = 0;
		int ten = 0;

		if (T % 10 != 0) {
			System.out.println(-1);
			return;
		}

		while (T >= 300) {
			threeHundred++;
			T -= 300;
		}

		while (T >= 60) {
			sixty++;
			T -= 60;
		}

		while (T >= 10) {
			ten++;
			T -= 10;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(threeHundred).append(" ");
		sb.append(sixty).append(" ");
		sb.append(ten);
		System.out.println(sb);

	}
}
