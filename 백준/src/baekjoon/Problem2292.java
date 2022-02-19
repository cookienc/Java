package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2292
 */
public class Problem2292 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		int count = 0;
		int range = 1;
		for (int i = 1; ; i++) {
			range += i * 6 - 6;
			if (N <= range) {
				count = i;
				break;
			}
		}

		System.out.println(count);
	}
}
