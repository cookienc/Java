package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/20444
 */
public class Problem20444 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		long start = -1;
		long end = n / 2;

		while (start + 1 < end) {
			long vertical = start + (end - start) / 2;
			long horizon = n - vertical;

			long papers = (vertical + 1) * (horizon + 1);
			if (papers >= k) {
				end = vertical;
				continue;
			}

			if (papers < k) {
				start = vertical;
			}
		}

		if ((n - end + 1) * (end + 1) == k) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
	}
}