package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/2577
 */
public class Problem2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int A = Integer.parseInt(bf.readLine());
		int B = Integer.parseInt(bf.readLine());
		int C = Integer.parseInt(bf.readLine());

		String result = String.valueOf(A * B * C);

		int[] count = new int[10];
		for (int i = 0; i < result.length(); i++) {
			count[result.charAt(i) - '0']++;
		}

		for (int i : count) {
			System.out.println(i);
		}
	}
}
