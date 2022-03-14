package programmers;

import java.util.Arrays;

public class Lottos {
	private static class Solution {
		public int[] solution(int[] lottos, int[] win_nums) {
			int zero = (int) Arrays.stream(lottos)
					.filter(i -> i == 0)
					.count();

			int[] count = Arrays.stream(lottos)
					.filter(lotto -> Arrays.stream(win_nums)
							.anyMatch(num -> num == lotto))
					.toArray();

			return findAnswer(count.length, zero);

		}

		private static int[] findAnswer(int count, int zero) {
			int[] answer = new int[2];

			if (count <= 1) {
				count = 1;
			}

			if (7 - count == zero) {
				return new int[]{1, 6};
			}

			answer[0] = 7 - (count + zero);
			answer[1] = 7 - count;

			return answer;
		}
	}
}
