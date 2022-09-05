package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2346
 */
public class Problem2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		boolean[] isChecked = new boolean[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int cnt = 1;
		isChecked[0] = true;

		int val = arr[idx];
		sb.append(1).append(" ");

		while (cnt < N) {
			boolean back = false;
			if (val < 0) {
				back = true;
			}

			val = Math.abs(val);
			while (val-- > 0) {
				if (back) {
					idx--;
					if (idx < 0) {
						idx += N;
					}
				} else {
					idx++;
					if (idx >= N) {
						idx %= N;
					}
				}
				while (isChecked[idx]) {
					if (back) {
						idx--;
						if (idx < 0) {
							idx += N;
						}
					} else {
						idx++;
						if (idx >= N) {
							idx %= N;
						}
					}
				}
			}
			cnt++;
			isChecked[idx] = true;
			val = arr[idx];
			sb.append(idx + 1).append(" ");
		}
		System.out.println(sb);
	}
}
