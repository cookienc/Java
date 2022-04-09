package programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42747?language=java#
 */
public class HIndex {
	static class Solution {
		public int solution(int[] citations) {

			Integer[] cite = Arrays.stream(citations)
					.boxed()
					.sorted(Comparator.reverseOrder())
					.toArray(Integer[]::new);

			int count = 0;

			for (int i = 0; i < cite.length; i++) {
				int tmp = cite[i];

				if (tmp >= i + 1) {
					count = i + 1;
				}
			}

			return count;
		}
	}
}
