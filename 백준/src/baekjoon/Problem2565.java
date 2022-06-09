package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2565
 */
public class Problem2565 {

	private static int[][] wire;
	private static int[] dp;
	private static int N;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		wire = new int[N][2];
		dp = new int[N];
		initialize(br, wire);

		lis();

		System.out.println(N - max);
	}

	private static void lis() {

		for (int i = 0; i < N; i++) {

			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(dp[i], max);
		}
	}

	private static void initialize(BufferedReader br, int[][] wire) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			wire[i][0] = from;
			wire[i][1] = to;
		}

		Arrays.sort(wire, (w1, w2) -> w1[0] - w2[0]);
	}
}
