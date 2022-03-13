package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 600};
		int[] solution = Solution.solution(genres, plays);
		for (int i : solution) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static class Solution {
		public static int[] solution(String[] genres, int[] plays) {

			//초기화
			Map<String, List<Integer>> map = new HashMap<>();
			Map<String, Integer> playCount = new HashMap<>();
			for (int i = 0; i < genres.length; i++) {
				if (map.containsKey(genres[i])) {
					map.get(genres[i]).add(plays[i]);
					playCount.merge(genres[i], plays[i], Integer::sum);
					continue;
				}
				List<Integer> tmp = new ArrayList<>();
				tmp.add(plays[i]);
				map.put(genres[i], tmp);
				playCount.put(genres[i], plays[i]);
			}

			List<Integer> list = new ArrayList<>();
			List<String> keyList = playCount.entrySet().stream()
					.sorted((s1, s2) -> s2.getValue() - s1.getValue())
					.map(e -> e.getKey())
					.collect(Collectors.toList());
			while (!keyList.isEmpty()) {
				String key = keyList.remove(0);

				List<Integer> tmp = map.entrySet().stream()
						.filter(m -> key.equals(m.getKey()))
						.map(e -> e.getValue())
						.findAny().get();

				Integer[] arr = tmp.stream()
						.sorted(Comparator.reverseOrder())
						.toArray(Integer[]::new);

				if (arr.length >= 2) {
					list.add(arr[0]);
					list.add(arr[1]);
				} else {
					list.add(arr[0]);
				}
			}

			int[] answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				int value = list.get(i);
				for (int j = 0; j < plays.length; j++) {
					if (plays[j] == value) {
						answer[i] = j;
						plays[j] = -1;
						break;
					}
				}
			}
			return answer;
		}
	}
}