package programmers;

import java.util.*;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/72411?language=java#
 */
public class RenewalMenu {
	static class Solution {

		private static boolean[] isChecked;
		private static char[] food;
		private static Map<String, Integer> map;
		private static int flag;
		private static List<String> answer;

		public String[] solution(String[] orders, int[] course) {

			answer = new ArrayList<>();

			for (int i : course) {
				map = new HashMap<>();
				flag = i;
				for (String order : orders) {
					food = new char[i];
					isChecked = new boolean[order.length()];

					char[] tmp = new char[order.length()];
					for (int j = 0; j < order.length(); j++) {
						tmp[j] = order.charAt(j);
					}
					Arrays.sort(tmp);

/*
                for (char j : tmp) {
                    System.out.print(j);
                }
                System.out.println();
*/
					combination(0, 0, tmp);
				}
				findMax();
			}


			return answer.stream()
					.sorted()
					.toArray(String[]::new);
		}

		private static void findMax() {

			int max = 2;

			for (String key : map.keySet()) {
				max = Math.max(max, map.get(key));
			}

			for (String key : map.keySet()) {
				if (map.get(key) == max) {
					answer.add(key);
				}
			}
		}

		private static void combination(int depth, int start, char[] order) {

			if (depth == flag) {
				StringBuilder sb = new StringBuilder();
				for (char c : food) {
					sb.append(c + "");
				}

				map.merge(sb.toString(), 1, Integer::sum);

				return;
			}

			for (int i = start; i < order.length; i++) {
				if (isChecked[i]) {
					continue;
				}

				isChecked[i] = true;
				food[depth] = order[i];
				combination(depth + 1, i + 1, order);
				isChecked[i] = false;

			}
		}
	}
}
