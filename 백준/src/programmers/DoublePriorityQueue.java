package programmers;

import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42628
 */
public class DoublePriorityQueue {
	static class Solution {
		public int[] solution(String[] operations) {

			TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> a - b);
			StringTokenizer st;
			for (String op : operations) {
				st = new StringTokenizer(op, " ");
				String s = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				System.out.println(s + " " + number);
				if ("D".equals(s)) {
					if (map.isEmpty()) {
						continue;
					}

					if (number == 1) {
						map.remove(map.lastKey());
						continue;
					}

					map.remove(map.firstKey());
					continue;
				}

				map.put(number, number);
			}
			if (map.isEmpty()) {
				return new int[]{0, 0};
			}

			return new int[]{map.get(map.lastKey()), map.get(map.firstKey())};
		}
	}
}
