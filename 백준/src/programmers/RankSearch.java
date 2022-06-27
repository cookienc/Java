package programmers;

import java.util.*;

public class RankSearch {
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
		int[] answer = s.solution(info, query);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

	static class Solution {
		private static Map<String, List<Integer>> map;

		public static int[] solution(String[] info, String[] query) {
			int[] answer = new int[query.length];
			map = new HashMap<>();

			for (String i : info) {
				String[] str = i.split(" ");
				makeCase(str, "", 0);
			}

			for (String key : map.keySet()) {
				Collections.sort(map.get(key));
			}

			for (int i = 0; i < query.length; i++) {
				query[i] = query[i].replaceAll(" and ", "");
				String[] q = query[i].split(" ");
				if (map.containsKey(q[0])) {
					answer[i] = binarySearch(q[0], Integer.parseInt(q[1]));
				} else {
					answer[i] = 0;
				}
			}
			
			return answer;
		}

		private static int binarySearch(String key, int score) {
			List<Integer> list = map.get(key);

			int low = -1;
			int high = list.size();

			while (low + 1 < high) {
				int mid = low + (high - low) / 2;

				if (list.get(mid) < score) {
					low = mid;
				} else {
					high = mid;
				}
			}

			return list.size() - high;
		}

		private static void makeCase(String[] str, String s, int cnt) {
			if (cnt == 4) {
				if (map.containsKey(s)) {
					map.get(s).add(Integer.parseInt(str[4]));
					return;
				}

				List<Integer> list = new ArrayList<>();
				list.add(Integer.parseInt(str[4]));
				map.put(s, list);
				return;
			}

			makeCase(str, s + "-", cnt + 1);
			makeCase(str, s + str[cnt], cnt + 1);
		}
	}
}
