package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/60058?language=java#
 */
public class TransformBracket {
	static class Solution {

		private static StringBuilder answer = new StringBuilder();

		public String solution(String p) {
			if (p.length() == 0) {
				return "";
			}

			substract(p);

			return answer.toString();
		}

		private static boolean isRight(String s) {
			int left = 0;
			int right = 0;
			boolean ret = true;

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					left++;
				} else {
					right++;
				}

				if (right > left) {
					ret = false;
					break;
				}
			}

			return ret;
		}

		private static void manipulate(String s) {
			s = s.substring(1, s.length() - 1);

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					answer.append(")");
				} else {
					answer.append("(");
				}
			}
		}

		private static void substract(String p) {

			StringBuilder u = new StringBuilder();
			StringBuilder v = new StringBuilder();

			int left = 0;
			int right = 0;

			for (int i = 0; i < p.length(); i++) {
				char c = p.charAt(i);

				if (c == '(') {
					left++;
				} else {
					right++;
				}

				u.append(c);

				if (left == right) {
					v.append(p.substring(i + 1, p.length()));
					break;
				}
			}

			if (isRight(u.toString())) {
				answer.append(u.toString());

				if(isRight(v.toString())) {
					answer.append(v.toString());
				} else {
					substract(v.toString());
				}
			} else {
				answer.append("(");
				substract(v.toString());
				answer.append(")");

				manipulate(u.toString());
			}
		}
	}
}
