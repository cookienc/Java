package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/92341?language=java#
 */
public class ParkingFeeCalculation {
	static class Solution {

		private static final String MAX_TIME = "23:59";

		private static Map<String, String> map;
		private static Map<String, Integer> time;
		private static Map<String, Integer> fee;

		public int[] solution(int[] fees, String[] records) {

			map = new HashMap<>();
			time = new HashMap<>();
			fee = new TreeMap<>();

			for (int i = 0; i < records.length; i++) {
				String[] word = records[i].split(" ");
				String name = word[1];
				String current = word[0];

				addTime(name, current);
			}

			if(!map.isEmpty()) {
				addRest();
			}

			calculateFee(fees);

			return fee.entrySet().stream()
					.mapToInt(Map.Entry::getValue)
					.toArray();
		}

		private static void calculateFee(int[] fees) {

			int flag = fees[0];
			int standardFee = fees[1];
			int overTime = fees[2];
			int overFee = fees[3];


			for (String key : time.keySet()) {
				int total = time.get(key);
				System.out.print("name : " + key + " total : " + total + "\n");
				if (total <= flag) {
					fee.put(key, standardFee);
					continue;
				}

				fee.put(key, standardFee +
						(int) Math.ceil((double) (total - flag) / overTime)
								* overFee);
			}

		}

		private static void addRest() {
			for (String s : map.keySet()) {
				int ct = calculateTime(MAX_TIME, map.get(s));
				time.merge(s, ct, Integer::sum);
			}
		}

		private static void addTime(String name, String current) {
			if (!map.containsKey(name)) {
				map.put(name, current);
			} else {
				String before = map.remove(name);
				int ct = calculateTime(current, before);
				time.merge(name, ct, Integer::sum);
			}
		}

		private static int calculateTime(String after, String before) {
			String[] a = after.split(":");
			String[] b = before.split(":");

			int hourA = Integer.parseInt(a[0]);
			int hourB = Integer.parseInt(b[0]);
			int minA = Integer.parseInt(a[1]);
			int minB = Integer.parseInt(b[1]);

			if (minA < minB) {
				hourA--;
				minA += 60;
			}

			return (hourA - hourB) * 60 + (minA - minB);
		}
	}
}
