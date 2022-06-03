package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/7795
 */
public class Problem7795 {

	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int[] a = new int[A];
			int[] b = new int[B];

			initializeArrays(br, A, B, a, b);

			int sum = 0;
			for (int i = 0; i < A; i++) {

				int low = -1;
				int high = B;
				int flag = a[i];

				while (low + 1 < high) {
					int mid = low + ((high - low) / 2);

					if (b[mid] >= flag) {
						high = mid;
					} else {
						low = mid;
					}
				}

				if (high == B) {
					sum += B;
					continue;
				}

				if (high != 0) {
					if (b[high - 1] <= flag) {
						sum += high;
					}
				} else {
					if (b[high] < flag) {
						sum += 1;
					}
				}
			}
			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}

	private static void initializeArrays(BufferedReader br, int A, int B, int[] a, int[] b) throws IOException {
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(b);
	}
}
