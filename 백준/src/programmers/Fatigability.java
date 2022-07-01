package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/87946#
 */
public class Fatigability {
	static class Solution {

		private static int answer;
		private static int size;
		private static int K;

		private static int[] choice;
		private static boolean[] isVisited;
		private static int[][] dungeons;

		public int solution(int k, int[][] dungeons) {

			size = dungeons.length;
			choice = new int[size];
			isVisited = new boolean[size];
			Solution.dungeons = dungeons;
			K = k;

			permutation(0);

			return answer;
		}

		private static void permutation(int depth) {

			if (depth == size) {
				count();
				return;
			}

			for (int i = 0; i < size; i++) {
				if (isVisited[i]) {
					continue;
				}

				isVisited[i] = true;
				choice[depth] = i;
				permutation(depth + 1);
				isVisited[i] = false;
			}
		}

		private static void count() {

			int fatigue = K;
			int count = 0;

			for (int idx : choice) {
				int[] d = dungeons[idx];
				int minimum = d[0];
				int pay = d[1];

				if (fatigue < minimum) {
					break;
				}

				fatigue -= pay;
				count++;
			}

			answer = Math.max(answer, count);
		}
	}
}
