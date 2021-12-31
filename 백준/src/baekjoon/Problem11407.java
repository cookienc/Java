package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11047
 */
public class Problem11407 {

	private static int[] money;
	private static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int k = Integer.parseInt(stringTokenizer.nextToken());

		money = new int[n];

		for (int i = n - 1; i >= 0; i--) {
			money[i] = Integer.parseInt(bufferedReader.readLine());
		}

		while (!(k == 0)) {
			for (int i : money) {
				if (k - i < 0) {
					continue;
				}
				count += k / i;
				k -= (k / i) * i;
			}
		}

		System.out.println(count);
	}
}
