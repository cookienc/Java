package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12947
 */
public class HarshadNumber {
	static class Solution {
		public boolean solution(int x) {
			String number = String.valueOf(x);
			int sum = 0;

			for (int i = 0; i < number.length(); i++) {
				sum += number.charAt(i) - '0';
			}

			if (x % sum == 0) {
				return true;
			}

			return false;
		}
	}
}
