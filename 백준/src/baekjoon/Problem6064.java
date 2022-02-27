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

			int lcm = M * N / gcd(M, N);
			int n = 0;
			int answer = -1;
			while (n * M < lcm) {
				if ((n * M + x - y) % N == 0) {
					answer = n * M + x;
					break;
				}
				n++;
			}
			sb.append(answer)
					.append(NEW_LINE);
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
