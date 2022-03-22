package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {
	static class Solution {
		private static Queue<Integer> progress;
		private static Queue<Integer> speed;
		private static List<Integer> answer;

		public int[] solution(int[] progresses, int[] speeds) {

			progress = new LinkedList<Integer>();
			speed = new LinkedList<Integer>();
			answer = new ArrayList<Integer>();

			for (int i = 0; i < progresses.length; i++) {
				progress.offer(progresses[i]);
				speed.offer(speeds[i]);
			}

			while(!progress.isEmpty()) {

				int count = 0;
				while (progress.size() != 0 && progress.peek() == 100) {
					count++;
					progress.poll();
					speed.poll();
				}

				int size = progress.size();

				while (size-- > 0) {
					int cur = progress.poll();
					int growth = speed.poll();

					speed.offer(growth);
					if (cur + growth >= 100) {
						progress.offer(100);
						continue;
					}
					progress.offer(cur + growth);
				}

				if (count != 0) {
					answer.add(count);
				}
			}

			return answer.stream()
					.mapToInt(l -> l)
					.toArray();
		}
	}
}
