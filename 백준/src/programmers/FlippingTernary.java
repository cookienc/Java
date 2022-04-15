package programmers;

import java.util.Stack;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/68935
 */
public class FlippingTernary {
	static class Solution {
		public int solution(int n) {
			Stack<Integer> toTernary = new Stack<>();

			while (n >= 3) {
				toTernary.push(n % 3);
				n /= 3;
			}
			toTernary.push(n);

			int count = 0;
			int sum = 0;
			while (!toTernary.isEmpty()) {
				Integer i = toTernary.pop();

				sum += i * (int) Math.pow(3, count++);
			}

			return sum;
		}
	}
}
