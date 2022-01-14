package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1057
 */
public class Problem1057 {

	private static int N;
	private static int a;
	private static int b;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		N = Integer.parseInt(stringTokenizer.nextToken());
		a = Integer.parseInt(stringTokenizer.nextToken());
		b = Integer.parseInt(stringTokenizer.nextToken());

		boolean[] array = new boolean[N];
		int count = 1;
		
		while (true) {

			if (b == N || (N % 2 == 1)) {
				count++;
				nextRound();
			}

			if (Math.abs(a - b) == 1) {
				if ((a % 2 == 1) && (b % 2 == 0)) {
					break;
				}
			}
			
			count++;
			nextRound();
		}
		System.out.println(count);
	}

	private static void nextRound() {
		a = a / 2 + a % 2;
		b = b / 2 + b % 2;
	}
}
