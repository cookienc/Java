package programmers;

import java.util.Arrays;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12982?language=java#
 */
public class Budget {
	static class Solution {
		public int solution(int[] d, int budget) {
			int answer = 0;

			Arrays.sort(d);

			for (int i = 0; i < d.length; i++) {
				if (d[i] <= budget) {
					budget = budget - d[i];
					answer++;
					continue;
				}
					break;
			}
			return answer;
		}
	}
}
