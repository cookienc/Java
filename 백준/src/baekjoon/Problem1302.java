package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 출처: https://www.acmicpc.net/problem/1302
 */
public class Problem1302 {
	public static void main(String[] args) throws IOException {

		Map<String, Integer> map = new HashMap<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			map.merge(br.readLine(), 1, Integer::sum);
		}

		String maxKey = map.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.map(Map.Entry::getKey)
				.findFirst().get();

		Integer maxValue = map.get(maxKey);
		String answer = map.entrySet().stream()
				.filter(m -> m.getValue().equals(maxValue))
				.sorted(Map.Entry.comparingByKey())
				.map(Map.Entry::getKey)
				.findFirst().get();

		System.out.println(answer);
	}
}
