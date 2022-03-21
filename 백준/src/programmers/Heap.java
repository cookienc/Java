package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
	static class Solution {
		public int solution(int[] scoville, int K) {

			PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.naturalOrder());

			for (int i : scoville) {
				queue.offer((long) i);
			}

			int count = 0;
			while (true) {
				Long smallest = queue.poll();

				if (smallest >= K) {
					break;
				}

				if (queue.isEmpty()) {
					return -1;
				}

				count++;
				Long next = queue.poll();

				queue.offer(smallest + 2 * next);
			}

			return count;
		}
	}
}
