package programmers;

import java.util.*;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/67258#
 */
public class JewelryShopping {
	static class Solution {

		public int[] solution(String[] gems) {

			Set<String> set = new HashSet<>();

			for (String s : gems) {
				set.add(s);
			}

			int type = set.size();

			Map<String, Integer> map = new HashMap<>();

			int low = 0;
			int high = 0;

			List<Node> list = new ArrayList<>();
			map.put(gems[0], 1);
			while (true) {
				if (map.size() != type) {
					high++;

					if (high == gems.length) {
						break;
					}

					map.merge(gems[high], 1, Integer::sum);
				} else {
					list.add(new Node(low + 1, high + 1, high - low));
					if (map.get(gems[low]) == 1) {
						map.remove(gems[low]);
					} else {
						map.merge(gems[low], 1, (cnt1, cnt2) -> cnt1 - 1);
					}
					low++;
				}
			}

			Node[] n = list.stream()
					.sorted(Comparator.comparing(Node::getDis)
							.thenComparing(Node::getStart))
					.limit(1)
					.toArray(Node[]::new);

			return new int[]{n[0].start, n[0].end};
		}

		private static class Node {
			int start;
			int end;
			int dis;

			Node(int start, int end, int dis) {
				this.start = start;
				this.end = end;
				this.dis = dis;
			}

			public int getStart() {
				return this.start;
			}
			public int getDis() {
				return this.dis;
			}
		}
	}
}
