package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class TestExam {
	static class Solution {

		private static int[] one = {1, 2, 3, 4, 5};
		private static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
		private static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		public int[] solution(int[] answers) {

			int sizeOne = one.length;
			int sizeTwo = two.length;
			int sizeThree = three.length;
			int[] right = new int[3];

			for (int i = 0; i < answers.length; i++) {
				if (answers[i] == one[i % sizeOne]) {
					right[0]++;
				}
				if (answers[i] == two[i % sizeTwo]) {
					right[1]++;
				}
				if (answers[i] == three[i % sizeThree]) {
					right[2]++;
				}
			}

			Integer max = Arrays.stream(right)
					.boxed()
					.sorted(Comparator.reverseOrder())
					.findFirst().get();

			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				if (right[i] == max) {
					list.add(i + 1);
				}
			}

			return list.stream()
					.mapToInt(l -> l)
					.toArray();
		}
	}
}
