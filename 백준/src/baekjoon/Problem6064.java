package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처:  https://www.acmicpc.net/problem/6064
 */
public class Problem6064 {

	private static final StringBuilder sb = new StringBuilder();
	public static final String NEW_LINE = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		StringTokenizer st;
		while (T-- > 0) {
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == M) {
				x = 0;
			}

			boolean hasAnswer = false;
			int year = 0;
			int yDot = 0;
			int count = 0;
			int max = M * N / gcd(M, N);

			while (year <= max) {
				year = x + count++ * M;
				yDot = year % N;

				if (yDot == 0) {
					yDot = N;
				}

				if (yDot == y) {
					hasAnswer = true;
					break;
				}
			}

			if (hasAnswer) {
				sb.append(year)
						.append(NEW_LINE);
			} else {
				sb.append(-1)
						.append(NEW_LINE);
			}
		}
		System.out.println(sb);
	}

	private static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		}
		return gcd(n, m % n);
	}
}
