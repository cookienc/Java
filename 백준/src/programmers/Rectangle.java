package programmers;

import java.util.Arrays;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/86491?language=java
 */
public class Rectangle {
	static class Solution {
		public int solution(int[][] sizes) {

			int last = sizes.length - 1;

			for (int i = 0; i <= last; i++) {
				int first = sizes[i][0];
				int second = sizes[i][1];

				if (first < second) {
					sizes[i][0] = second;
					sizes[i][1] = first;
				}
			}

			int sum = 0;
			Arrays.sort(sizes, (s1, s2) -> (s1[0] - s2[0]));
			sum = sizes[last][0];
			Arrays.sort(sizes, (s1, s2) -> s1[1] - s2[1]);
			sum *= sizes[last][1];

			return sum;
		}
	}
}
