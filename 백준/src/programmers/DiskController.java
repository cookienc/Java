package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42627
 */
public class DiskController {

	static class Solution {
		public int solution(int[][] jobs) {
			PriorityQueue<Job> wait = new PriorityQueue(new Comparator<Job>() {
				@Override
				public int compare(Job j1, Job j2) {
					return j1.time - j2.time;
				}
			});

			for (int[] job : jobs) {
				wait.offer(new Job(job[0], job[1]));
			}

			PriorityQueue<Job> pq = new PriorityQueue(new Comparator<Job>() {
				@Override
				public int compare(Job j1, Job j2) {
					return j1.period - j2.period;
				}
			});

			int count = 0;
			int sum = 0;
			int time = 0;

			while (count < jobs.length) {

				while (!wait.isEmpty() && (time >= wait.peek().time)) {
					pq.offer(wait.poll());
				}

				if (!pq.isEmpty()) {
					Job j = pq.poll();
					sum += j.period + (time - j.time);
					time += j.period;
					count++;
				} else {
					time++;
				}
			}
			return sum / count;
		}

		private class Job {
			public int time;
			public int period;

			public Job(int time, int period) {
				this.time = time;
				this.period = period;
			}
		}
	}
}