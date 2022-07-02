package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/84512
 */
public class VowelDictionary {
	static class Solution {
		public int solution(String word) {
			String dic = "AEIOU";
			int[] step = {781, 156, 31, 6, 1};
			int answer = 0;

			for (int i = word.length() - 1; i >= 0; i--) {
				answer += dic.indexOf(word.charAt(i)) * step[i] + 1;
			}
			return answer;
		}
	}
}
