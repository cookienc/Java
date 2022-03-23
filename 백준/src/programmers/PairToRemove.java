package programmers;

import java.util.Stack;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12973
 */
public class PairToRemove {
	static class Solution
	{
		public int solution(String s)
		{
			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (stack.isEmpty()) {
					stack.push(c);
					continue;
				}

				if (stack.peek() == c) {
					stack.pop();
					continue;
				}

				stack.push(c);
			}

			if (stack.isEmpty()) {
				return 1;
			}
			return 0;
		}
	}
}
