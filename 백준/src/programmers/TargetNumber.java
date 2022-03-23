package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class TargetNumber {
	static class Solution {

		private static boolean[] isVisited;
		private static int count = 0;

		public int solution(int[] numbers, int target) {

			dfs(0, 0, target, numbers);

			return count;
		}

		private static void dfs(int depth, int sum, int target, int[] numbers) {

			if (depth == numbers.length) {
				if (target == sum) {
					count++;
				}
				return;
			}

			dfs(depth + 1, sum + numbers[depth], target, numbers);
			dfs(depth + 1, sum - numbers[depth], target, numbers);
		}
	}
}
