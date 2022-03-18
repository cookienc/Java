package programmers;

public class PlusYinYang {
	class Solution {
		public int solution(int[] absolutes, boolean[] signs) {
			int sum = 0;

			for(int i = 0; i < absolutes.length; i++) {
				if (signs[i]) {
					sum += absolutes[i];
					continue;
				}
				sum -= absolutes[i];
			}

			return sum;
		}
	}
}
