package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/22862
 */
public class Problem22862 {
	private static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int odd = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] % 2 != 0) {
				odd++;
			}
		}

		if (odd <= K) {
			System.out.println(N - odd);
			return;
		}

		int left = 0;
		int right = 0;
		int cnt = 0;
		int del = 0;

		boolean end = false;
		while (left <= right && right < N) {
			while (del != K || arr[right] % 2 == 0) {
				if (right + 1 == N) {
					end = true;
					break;
				}

				if (arr[right++] % 2 != 0) {
					del++;
				} else {
					cnt++;
				}
			}

			if (end) {
				break;
			}

			max = Math.max(max, cnt);

			if (arr[left++] % 2 != 0) {
				del--;
			} else {
				cnt--;
			}
		}
		System.out.println(max);
	}
}
