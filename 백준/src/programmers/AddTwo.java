package programmers;

import java.util.*;

public class AddTwo {
	static class Solution {
		private static Set<Integer> answer;
		private static int[] numbers;
		private static boolean[] isVisited;
		private static int[] choice;

		public int[] solution(int[] numbers) {
			answer = new HashSet<>();
			Solution.numbers = numbers;
			choice = new int[2];
			isVisited = new boolean[numbers.length];

			combination(0, 0);

			return answer.stream()
					.mapToInt(Integer::intValue)
					.sorted()
					.toArray();
		}

		private static void combination(int start, int depth) {

			if (depth == 2) {
				int sum = 0;
				for (int i : choice) {
					sum += numbers[i];
				}
				answer.add(sum);
				return;
			}

			for (int i = start; i < numbers.length; i++) {
				if (isVisited[i]) {
					continue;
				}
				isVisited[i] = true;
				choice[depth] = i;
				combination(i + 1, depth + 1);
				isVisited[i] = false;
			}
		}
	}
}