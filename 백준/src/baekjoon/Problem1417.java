package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 출처: https://www.acmicpc.net/problem/1417
 */
public class Problem1417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(0);
			return;
		}

		int[] arr = new int[N - 1];
		int dasom = Integer.parseInt(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;
		while (true) {
			Arrays.sort(arr);
			if (dasom > arr[N - 2]) {
				break;
			}

			cnt++;
			dasom++;
			arr[N - 2]--;
		}
		System.out.println(cnt);
	}
}
