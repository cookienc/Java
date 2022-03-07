package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11659
 */
public class Problem11659 {

	public static final String NEW_LINE = "\n";
	private static int[] array;
	private static int[] dp;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		array = new int[N + 1];
		dp = new int[N + 1];

		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			if (i >= 2) {
				dp[i] = dp[i - 1] + array[i];
				continue;
			}
			dp[i] = array[i];
		}

		while (M-- > 0) {
			st = new StringTokenizer(bf.readLine());

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (i == j) {
				sb.append(array[i])
						.append(NEW_LINE);
				continue;
			}

			if (i > 1) {
				sb.append(dp[j] - dp[i - 1])
						.append(NEW_LINE);
				continue;
			}

			sb.append(dp[j])
					.append(NEW_LINE);
		}

		System.out.println(sb);
	}
}
