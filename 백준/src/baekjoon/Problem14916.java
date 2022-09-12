package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/14916
 */
public class Problem14916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int cnt = 0;

		if (n % 5 == 0) {
			System.out.println(n / 5);
			System.exit(0);
		}

		while (n != 0) {
			if (n - 2 < 0) {
				System.out.println(-1);
				System.exit(0);
			}
			n -= 2;
			cnt++;

			if (n % 5 == 0) {
				cnt += n / 5;
				break;
			}

			if (n == 1) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		System.out.println(cnt);
	}
}
