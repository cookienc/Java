package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 출처: https://school.programmers.co.kr/learn/courses/30/lessons/17684#
 */
public class Compression {
	class Solution {
		public int[] solution(String msg) {
			char[] words = msg.toCharArray();

			List<Integer> answer = new ArrayList<>();
			List<String> dictionary = new ArrayList<>();
			int index = 0;
			dictionary.add("");
			for (index = 0; index < 26; index++) {
				dictionary.add(String.valueOf((char) ('A' + index)));
			}

			for (int i = 0; i < words.length; i++) {
				String next = String.valueOf(words[i]);
				boolean change = false;
				boolean has = true;

				for (int j = i + 1; j < words.length; j++) {
					next += String.valueOf(words[j]);
					change = true;
					i = j;

					if (!dictionary.contains(next)) {
						has = false;
						break;
					}
				}
				dictionary.add(next);
				if (change && !has) {
					next = next.substring(0, next.length() - 1);
					i--;
				}
				answer.add(dictionary.indexOf(next));
			}

			return answer.stream()
					.mapToInt(i -> i).toArray();
		}
	}
}
