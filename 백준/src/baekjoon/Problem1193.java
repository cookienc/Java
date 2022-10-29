package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/1193
 */
public class Problem1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 0;
		int n = 0;
		while (true) {
			n++;
			count += n;
			if (count >= N) {
				if (n % 2 == 0) {
					System.out.println(N - count + n + "/" + (count - N + 1));
				} else {
					System.out.println((count - N + 1) + "/" + (N - count + n));
				}
				break;
			}
		}
	}
}
