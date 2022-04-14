package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/77884?language=java#
 */
public class NumberAndAdditionOfFactors {
	static class Solution {
		public int solution(int left, int right) {

			int sum = 0;
			for (int i = left; i <= right; i++) {
				if(count(i)) {
					sum += i;
					continue;
				}
				sum -= i;
			}

			return sum;
		}

		private static boolean count(int num) {

			if (num == 1) {
				return false;
			}

			int[] count = new int[num + 1];

			for (int i = 2; i < count.length; i++) {
				if (num % i == 0) {
					count[i]++;
					num /= i;
					i--;
				}
			}

			int sum = 1;

			for (int i = 2; i < count.length; i++) {
				if (count[i] == 0) {
					continue;
				}
				sum *= (count[i] + 1);
			}

			if (sum == 1 || sum % 2 == 0) {
				return true;
			}
			return false;
		}
	}
}
