package programmers;

import java.util.Arrays;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/12982?language=java#
 */
public class Budget {
	static class Solution {
		public int solution(int[] d, int M) {
			int answer = 0;
			long sum = 0;

			Arrays.sort(d);

			for (int b : d) {
				sum += b;
			}

			int n = d.length;

			if (sum < M) {
				answer = d[n - 1];
			} else {
				sum = 0;
				int left = 0;
				int right = d[n - 1];

				while (left <= right) {
					int mid = (left + right) / 2;
					sum = 0;
					for (int i = 0; i < n; i++) {
						if (d[i] < mid)
							sum += d[i];
						else
							sum += mid;
					}
					if (sum > M) {
						right = mid - 1;
					} else {
						left = mid + 1;
						answer = mid;
					}
				}
			}

			return answer;
		}
	}
}
