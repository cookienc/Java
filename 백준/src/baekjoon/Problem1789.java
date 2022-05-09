package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1789
 */
public class Problem1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());

		long sum = 0;
		int count = 0;

		for (int i = 1; ; i++) {
			if (sum > S) {
				break;
			}

			sum += i;
			count++;
		}

		System.out.println(count - 1);
	}
}

