package programmers;

import java.util.Arrays;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42862#
 */
public class GymUniform {
	private static class Solution {

		private static int max = Integer.MIN_VALUE;
		private static int size;
		public int solution(int n, int[] lost, int[] reserve) {

			size = n;
			int[] member = new int[n];

			Arrays.fill(member, 1);

			for (int i = 0; i < lost.length; i++) {
				member[lost[i] - 1]--;
			}

			for (int i = 0; i < reserve.length;i++) {
				member[reserve[i] - 1]++;
			}

			findMax(member);

			return max;
		}

		private static void findMax(int[] student) {

			for (int i = 0; i < size; i++) {
				if (student[i] == 2) {
					if (i + 1 < size && student[i + 1] == 0) {
						int[] tmp = Arrays.copyOf(student, student.length);
						tmp[i]--;
						tmp[i + 1]++;
						findMax(tmp);
					}

					if (i - 1 >= 0 && student[i - 1] == 0) {
						int[] tmp = Arrays.copyOf(student, student.length);
						tmp[i]--;
						tmp[i - 1]++;
						findMax(tmp);
					}
				}
			}
			int count = 0;

			for (int i : student) {
				System.out.print(i + " ");
				if (i >= 1) {
					count++;
				}
			}
			System.out.println();
			max = Math.max(max, count);
		}
	}
}
