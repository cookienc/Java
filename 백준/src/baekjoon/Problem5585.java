package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/5585
 */
public class Problem5585 {

	private static final int[] coin = {500, 100, 50, 10, 5, 1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int money = 1000 - N;
		int count = 0;

		for (int i = 0; i < coin.length; i++) {
			while (true) {
				if (money % coin[i] == money) {
					break;
				}
				money -= coin[i];
				count++;
			}
		}

		System.out.println(count);
	}
}
