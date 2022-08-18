package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 출처: https://www.acmicpc.net/problem/4358
 */
public class Problem4358 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> trees = new HashMap<>();
		int cnt = 0;

		while (true) {
			String tree = br.readLine();

			if (tree == null || tree.isBlank()) {
				break;
			}

			trees.merge(tree, 1, Integer::sum);
			cnt++;
		}

		final int count = cnt;

		StringBuilder sb = new StringBuilder();
		trees.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey))
				.forEach((tree) -> {
					sb.append(tree.getKey()).append(" ")
							.append(String.format("%.4f", Math.round((double) tree.getValue() / count * 1000000) / (double) 10000)).append("\n");
				});

		System.out.println(sb);
	}
}
