package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/6359
 */
public class Problem6359 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n + 1];

			for (int i = 2; i <= n; i++) {
				for (int j = i; j <= n; j += i) {
					if (arr[j] == 0) {
						arr[j] = 1;
					} else {
						arr[j] = 0;
					}
				}
			}

			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (arr[i] == 0) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
