package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15486
 */
public class Problem15486 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 2];
		int[] P = new int[N + 2];
		int[] dp = new int[N + 2];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			T[i] = t;
			P[i] = p;
		}

		int max = 0;
		for (int i = 1; i <= N + 1; i++) {
			max = Math.max(max, dp[i]);
			int next = i + T[i];

			if (next > N + 1) {
				continue;
			}

			dp[next] = Math.max(max + P[i], dp[next]);
		}
		System.out.println(max);
	}
}
