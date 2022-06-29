package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12900
 */
public class Tiling2Xn {
	static class Solution {

		private static int[] dp;
		private static final int MOD = 1_000_000_007;

		public int solution(int n) {
			dp = new int[60_001];
			return recur(n);
		}

		private static int recur(int n) {

			if (n <= 0) {
				return 0;
			}

			if (n <= 3) {
				return n;
			}

			if (dp[n] != 0) {
				return dp[n];
			}

			dp[n] = (recur(n - 2) % MOD + recur(n - 1) % MOD) % MOD;

			return dp[n];
		}
	}
}
