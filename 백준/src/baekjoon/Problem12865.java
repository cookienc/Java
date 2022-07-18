package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/12865
 * 참고: https://fbtmdwhd33.tistory.com/60
 */
public class Problem12865 {

	private static int[][] dp;
	private static int[] W; // weight
	private static int[] V; // value

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		W = new int[N];
		V = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N][K + 1];

		for (int r = 0; r < N; r++) {
			for (int weight = 0; weight <= K; weight++) {

				if (r == 0) {
					if (W[r] > weight) {
						dp[r][weight] = 0;
					} else {
						dp[r][weight] = V[r];
					}
					continue;
				}

				if (W[r] > weight) {
					dp[r][weight] = dp[r - 1][weight];
				} else {
					dp[r][weight] = Math.max(dp[r - 1][weight], V[r]);
				}

				if (weight - W[r] >= 0) {
					dp[r][weight] = Math.max(dp[r - 1][weight], dp[r - 1][weight - W[r]] + V[r]);
				}
			}
		}
		System.out.println(dp[N - 1][K]);
	}
}