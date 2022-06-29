package programmers;

import java.util.Stack;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/76502?language=java#
 */
public class RotateParentheses {
	static class Solution {

		private static String[] bracket;
		private static String[] open = {"(", "[", "{"};
		private static String[] close = {")", "]", "}"};

		public int solution(String s) {
			bracket = s.split("");
			int count = bracket.length;
			int answer = 0;

			for (int start = 0; start < count; start++) {

				Stack<String> stack = new Stack<>();
				boolean right = true;
				for (int step = 0; step < count; step++) {
					int idx = (start + step) % count;

					if(!isItRight(stack, idx)) {
						right = false;
						break;
					}
				}

				if (stack.isEmpty() && right) {
					answer++;
				}
			}

			return answer;
		}

		private static boolean isItRight(Stack<String> stack, int idx) {

			String cur = bracket[idx];

			if (stack.isEmpty()) {
				stack.push(cur);
				return true;
			}

			String top = stack.peek();

			if (!isItOpen(top)) { // 맨위가 닫혀 있을 때
				return false;
			}

			if (!isItOpen(cur)) { // 맨위 열림, 현재 닫힘
				if(isItSame(top, cur)) { //모양 일치
					stack.pop();
					return true;
				}
				return false;
			}

			stack.push(cur);
			return true;

		}

		private static boolean isItSame(String a, String b) {

			int i = 0;
			int j = 0;

			for (i = 0; i < 3; i++) {
				if (open[i].equals(a)) {
					break;
				}
			}

			for (j = 0; j < 3; j++) {
				if (close[j].equals(b)) {
					break;
				}
			}

			if (i != 3 && j != 3 && i == j) {
				return true;
			}

			return false;
		}

		private static boolean isItOpen(String bracket) {
			for (String o : open) {
				if (o.equals(bracket)) {
					return true;
				}
			}

			return false;

		}
	}
}
