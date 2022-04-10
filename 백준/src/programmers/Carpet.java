package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
 */
public class Carpet {
	static class Solution {
		public int[] solution(int brown, int yellow) {

			int total = (brown + 4) / 2;
			int w = total - 3;
			int h = 3;

			for (; h <= w; h++, w--) {
				int count = (w - 2) * (h - 2);

				if (count == yellow) {
					break;
				}
			}

			return new int[]{w, h};
		}
	}
}
