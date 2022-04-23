package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/92342
 */
public class ArcheryCompetition {
	static class Solution {
		private static int[] res = {-1};
		private static int max = Integer.MIN_VALUE;
		private static int[] lion;
		private static int[] apeach;
		private static int N;

		public int[] solution(int n, int[] info) {

			N = n;
			apeach = info.clone();
			lion = new int[11];
			dfs(1);
			return res;
		}

		public void dfs(int cnt) {
			if (cnt == N + 1) {
				int aSum = 0;
				int lSum = 0;
				for (int i = 0; i <= 10; i++) {
					if (apeach[i] != 0 || lion[i] != 0) {
						if (apeach[i] < lion[i])
							lSum += 10 - i;
						else
							aSum += 10 - i;
					}
				}
				if (lSum > aSum) {
					if (lSum - aSum >= max) {
						res = lion.clone();
						max = lSum - aSum;
					}
				}
				return;
			}
			for (int j = 0; j <= 10 && lion[j] <= apeach[j]; j++) {
				lion[j]++;
				dfs(cnt + 1);
				lion[j]--;
			}
		}
	}
}
