package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/64062?language=java
 */
public class CrossTheSteppingStones {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.println(Solution.solution(stones, 3));
	}

	static class Solution {
		public static int solution(int[] stones, int k) {

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;

			for (int stone : stones) {
				max = Math.max(max, stone);
				min = Math.min(min, stone);
			}

			int low = min;
			int high = max;

			while (low <= high) {

				int mid = (low + high) / 2;

				if (canCross(stones, mid, k)) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}

			return high;
		}

		private static boolean canCross(int[] stones, int mid, int k) {

			int cnt = 0;

			for (int stone : stones) {
				if (stone < mid) {
					cnt++;
				} else {
					cnt = 0;
				}

				if (cnt >= k) {
					return false;
				}
			}


			return true;
		}
	}
}
