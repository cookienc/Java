package programmers;

public class PlainSquare {
	class Solution {
		public long solution(int w, int h) {
			long answer = 0;

			for (long l = 0L; l < w; l++) {
				answer += (long) h * l / w * 2;
			}

			return answer;
		}
	}
}
