package programmers;

import java.util.Arrays;

public class MakePrimeNumber {
	static class Solution {
		private static int[] choice = new int[3];
		private static boolean[] prime = new boolean[3001];
		private static int count = 0;

		static {
			findPrime();
		}

		public int solution(int[] nums) {

			dfs(0, 0, nums);

			return count;
		}

		private static void dfs(int depth, int start, int[] nums) {
			if (depth == 3) {
				int sum = 0;
				for (int i : choice) {
					sum += i;
				}
				if (prime[sum]) {
					count++;
				}
				return;
			}

			for (int i = start; i < nums.length; i++) {
				choice[depth] = nums[i];
				dfs(depth + 1, i + 1, nums);
			}
		}

		private static void findPrime() {

			Arrays.fill(prime, true);
			prime[1] = false;

			for (int i = 2; i * i <= 3000; i++) {
				for (int j = i * i; j <= 3000; j += i) {
					prime[j] = false;
				}
			}
		}
	}
}