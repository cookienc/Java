package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Printer {
	static class Solution {
		public int solution(int[] priorities, int location) {

			Queue<Paper> queue = new LinkedList<>();
			int[] flag = new int[10];

			for (int i = 0; i < priorities.length; i++) {
				flag[priorities[i]]++;
				queue.offer(new Paper(i, priorities[i]));
			}

			int cnt = 0;
			int max = findMax(flag);

			while (true) {

				Paper p = queue.poll();
				if (p.priority == max) {
					if (p.index == location) {
						cnt++;
						break;
					}
					cnt++;
					flag[p.priority]--;
					max = findMax(flag);
					continue;
				}

				queue.offer(p);
			}
			return cnt;
		}

		private static int findMax(int[] flag) {
			for (int i = 9; i >= 1; i--) {
				if (flag[i] != 0) {
					return i;
				}
			}
			return -1;
		}

		private static class Paper {
			int index;
			int priority;

			public Paper(int index, int priority) {
				this.index = index;
				this.priority = priority;
			}
		}
	}
}
