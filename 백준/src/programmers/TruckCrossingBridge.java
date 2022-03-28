package programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class TruckCrossingBridge {
	static class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {

			int maxTruck = bridge_length;
			int maxWeight = weight;

			Queue<Truck> truck = new LinkedList<>();
			for (int i : truck_weights) {
				truck.offer(new Truck(i, 0));
			}

			int time = 0;
			Queue<Truck> bridge = new LinkedList<>();
			while (true) {
				time++;
				int size = bridge.size();

				while (size-- > 0) {
					Truck going = bridge.poll();
					if (going.time >= bridge_length) {
						maxWeight += going.weight;
						maxTruck++;
						continue;
					}
					bridge.offer(new Truck(going.weight, going.time + 1));
				}
				if (!truck.isEmpty()) {

					Truck wait = truck.peek();

					if (maxWeight >= wait.weight && maxTruck >= 1) {
						maxWeight -= wait.weight;
						maxTruck--;
						bridge.offer(new Truck(wait.weight, 1));
						truck.poll();
					}
				}

				if (bridge.isEmpty()) {
					break;
				}
			}
			return time;
		}

		private class Truck {
			int weight;
			int time;

			public Truck(int weight, int time) {
				this.weight = weight;
				this.time = time;
			}
		}
	}
}
