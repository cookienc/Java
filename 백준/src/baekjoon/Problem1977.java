package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1977
 */
public class Problem1977 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		boolean[] num = new boolean[10001];
		for (int i = 1; i * i < 10001; i++) {
			num[i * i] = true;
		}

		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = M; i <= N; i++) {
			if (num[i]) {
				sum += i;
				min = Math.min(i, min);
			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
