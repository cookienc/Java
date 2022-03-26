package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class NewsClustering {
	public static void main(String[] args) {
		System.out.println(Solution.solution("FRANCE", "french"));
	}

	static class Solution {

		private static String pattern = "[A-Z]{2}";

		public static int solution(String str1, String str2) {

			str1 = str1.toUpperCase();
			str2 = str2.toUpperCase();

			Map<String, Integer> map1 = new HashMap<>();
			Map<String, Integer> map2 = new HashMap<>();

			substring(str1, map1);
			substring(str2, map2);

			int intersection = 0;
			int union = 0;

			if (map1.size() > map2.size()) {
				intersection = intersect(map2, map1);
				union = union(map2, map1);
			} else {
				intersection = intersect(map1, map2);
				union = union(map1, map2);
			}

			if (intersection == union) {
				intersection = 1;
				union = 1;
			}

			return (int) (((double) intersection / union) * 65536);
		}

		private static int union(Map<String, Integer> map1, Map<String, Integer> map2) {
			int count = 0;

			for (String key : map2.keySet()) {
				count += map2.get(key);
			}

			for (String key : map1.keySet()) {
				int oneSize = map1.get(key);

				int twoSize = 0;
				if (map2.containsKey(key)) {
					twoSize = map2.get(key);
				}

				if (oneSize <= twoSize) {
					continue;
				} else {
					count -= twoSize;
					count += oneSize;
				}
			}

			return count;
		}

		private static int intersect(Map<String, Integer> map1, Map<String, Integer> map2) {

			int count = 0;

			for (String key : map1.keySet()) {
				int oneSize = map1.get(key);

				int twoSize = 0;
				if (map2.containsKey(key)) {
					twoSize = map2.get(key);
				}

				if (twoSize == 0) {
					continue;
				}

				count += oneSize > twoSize? twoSize : oneSize;
			}

			return count;
		}

		private static void substring(String str, Map<String, Integer> map) {
			String tmp = "";

			for (int i = 0; i < str.length() - 1; i++) {
				tmp = str.substring(i, i + 2);
				if (Pattern.matches(pattern, tmp)) {
					map.merge(tmp, 1, Integer::sum);
				}
			}
		}
	}
}
