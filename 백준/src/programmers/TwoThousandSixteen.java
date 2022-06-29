package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12901#
 */
public class TwoThousandSixteen {
	static class Solution {

		private static int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		private static String[] date = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		public String solution(int m, int d) {
			int day = 1;

			int diff = d;
			for (int i = m - 1; i >= 1; i--) {
				diff += month[i];
			}
			diff -= day;

			day = (diff + 5) % 7;
			return date[day];
		}
	}
}
