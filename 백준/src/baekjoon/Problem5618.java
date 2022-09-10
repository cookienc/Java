package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/5618
 */
public class Problem5618 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= arr[0]; i++) {
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				if (arr[j] % i == 0) {
					cnt++;
				}
			}

			if (cnt == N) {
				sb.append(i).append("\n");
			}
		}
		System.out.println(sb);
	}
}
