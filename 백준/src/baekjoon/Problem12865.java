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

	private static Integer[][] dp;
	private static int[] W; // weight
	private static int[] V; // value

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		W = new int[N];
		V = new int[N];

		dp = new Integer[N][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(find(N - 1, K));

	}

	private static int find(int i, int k) {
		if (i < 0)
			return 0;

		if (dp[i][k] == null) {

			if (W[i] > k) {
				dp[i][k] = find(i - 1, k);
			}
			else {
				dp[i][k] = Math.max(find(i - 1, k), find(i - 1, k - W[i]) + V[i]);
			}
		}
		return dp[i][k];
	}
}