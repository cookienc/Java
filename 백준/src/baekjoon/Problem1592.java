package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1592
 */
public class Problem1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		arr[1] = 0;
		int idx = 1;
		while (true) {
			if (arr[idx] % 2 == 1) {
				idx += L;

				if (idx > N) {
					idx -= N;
				}

				arr[idx]++;
				if (arr[idx] == M) {
					break;
				}
				continue;
			}

			idx -= L;
			if (idx < 1) {
				idx += N;
			}
			arr[idx]++;
			if (arr[idx] == M) {
				break;
			}
		}

		int sum = -1;
		for (int i : arr) {
			sum += i;
		}
		System.out.println(sum);
	}
}
