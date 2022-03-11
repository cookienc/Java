package programmers;

public class KakaoBlind2021_1 {
	public static void main(String[] args) {
		System.out.println(Solution.solution("one4seveneight"));
		System.out.println(Solution.solution("23four5six7"));
		System.out.println(Solution.solution("2three45sixseven"));
		System.out.println(Solution.solution("123"));
	}
	private static class Solution {
		public static int solution(String s) {

			String answer = "";

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);

				if (isItNumber(c)) {
					answer += String.valueOf(c);
					continue;
				}

				String word = String.valueOf(c);
				for (int j = i + 1; j < s.length(); j++) {

					if (isItNumber(c)) {
						i = j;
						break;
					}
					word += String.valueOf(s.charAt(j));

					String tmp = findNumber(word);
					if(tmp != null) {
						i = j;
						answer += tmp;
						break;
					}
				}
			}
			return Integer.parseInt(answer);
		}
	}

	private static String findNumber(String word) {

		if ("zero".equals(word)) {
			return "0";
		}

		if ("one".equals(word)) {
			return "1";
		}

		if ("two".equals(word)) {
			return "2";
		}

		if ("three".equals(word)) {
			return "3";
		}

		if ("four".equals(word)) {
			return "4";
		}

		if ("five".equals(word)) {
			return "5";
		}

		if ("six".equals(word)) {
			return "6";
		}

		if ("seven".equals(word)) {
			return "7";
		}

		if ("eight".equals(word)) {
			return "8";
		}

		if ("nine".equals(word)) {
			return "9";
		}

		return null;
	}

	private static boolean isItNumber(char c) {
		return c >= '0' && c <= '9';
	}
}
