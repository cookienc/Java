package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Camouflage {
	class Solution {
		public int solution(String[][] clothes) {

			Map<String, List<String>> map = new HashMap<>();

			for (String[] cloth : clothes) {
				String name = cloth[0];
				String type = cloth[1];

				if (map.containsKey(type)) {
					map.get(type).add(name);
					continue;
				}

				List<String> list = new ArrayList<>();
				list.add(name);
				map.put(type, list);
			}

//         int sum = 1;
//         for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//             int count = 1;
//             count += entry.getValue().size();
//             sum *= count;
//         }

//         return sum - 1;

			return map.entrySet().stream()
					.mapToInt(l -> l.getValue().size() + 1)
					.reduce(1, (i1, i2) -> i1 * i2) - 1;
		}
	}
}
