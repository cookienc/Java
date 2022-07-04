package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12981?language=java#
 */
public class WordChain {

	static class Solution {

		private static int[] member;
		private static int length;
		private static String[] words;
		private static Map<String, Boolean> map;

		public int[] solution(int n, String[] words) {

			Solution.words = words;
			map = new HashMap<>();
			member = new int[n];
			length = words.length;

			int idx = 0;

			for (idx = 0; idx < length; idx++)  {
				if (idx == 0) {
					member[0]++;
					map.put(words[idx], true);
					continue;
				}

				if (!check(idx - 1, idx)) {
					break;
				}

				map.put(words[idx], true);
				member[idx % n]++;
			}

			if (idx == words.length) {
				return new int[]{0, 0};
			}

			return new int[]{idx % n + 1, member[idx % n] + 1};
		}

		private static boolean check(int before, int after) {

			//두번 반복한 문자인지
			if (map.containsKey(words[after])) {
				return false;
			}

			//이어지는 글자인지
			if (words[before].charAt(words[before].length() - 1) == words[after].charAt(0)) {
				return true;
			}

			return false;
		}
	}
}
