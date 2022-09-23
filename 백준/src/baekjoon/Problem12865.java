package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/12865
 */
public class Problem12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][2];
		int[][] dp = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // W
			arr[i][1] = Integer.parseInt(st.nextToken()); // K
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

		for (int j = 1; j <= K; j++) {
			for (int i = 1; i <= N; i++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				if (j - arr[i][0] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - arr[i][0]] + arr[i][1]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}