package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/9184
 */
public class Problem9184 {

	public static final String NEW_LINE = "\n";
	private static int[][][] dp;
	private static final StringBuilder sb = new StringBuilder();
	public static final String OPEN_BRACKET = "w(";
	public static final String SPACE = ", ";
	public static final String CLOSE_BRACKET = ")";
	public static final String EQUALS = " = ";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new int[21][21][21];
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				break;
			}

			sb.append(OPEN_BRACKET).append(a).append(SPACE).append(b)
					.append(SPACE).append(c).append(CLOSE_BRACKET)
					.append(EQUALS).append(w(a, b, c)).append(NEW_LINE);
		}

		System.out.println(sb);
	}

	private static int w(int a, int b, int c) {

		if ((a>=0 && b>=0 && c>=0) && (a <= 20 && b <= 20 && c <= 20)) {
			if (dp[a][b][c] != 0) {
				return dp[a][b][c];
			}
		}

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}

		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1)
					+ w(a, b - 1, c - 1) - w(a, b - 1, c);
		}

		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) +
				w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}
}
