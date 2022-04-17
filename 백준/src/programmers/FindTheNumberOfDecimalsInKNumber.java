package programmers;

import java.util.Stack;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/92335#
 */
public class FindTheNumberOfDecimalsInKNumber {
	static class Solution {

		private static int result = 0;

		public int solution(int n, int k) {

			Stack<Integer> stack = new Stack<>();
			while (n >= k) {
				stack.push(n % k);
				n /= k;
			}
			stack.push(n);

			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.setLength(0);

				while (!stack.isEmpty() && stack.peek() != 0) {
					sb.append(stack.pop());
				}

				if(findPrime(Long.parseLong(sb.toString()))) {
					result++;
				}
				while (!stack.isEmpty() && stack.peek() == 0) {
					stack.pop();
				}
			}

			return result;
		}

		private static boolean findPrime(long num) {

			if (num == 0 || num == 1) {
				return false;
			}

			if (num == 2) {
				return true;
			}

			for (int i = 2; i < (int) Math.sqrt(num) + 1; i++) {

				if (num % i == 0) {
					return false;
				}
			}

			return true;
		}
	}
}
