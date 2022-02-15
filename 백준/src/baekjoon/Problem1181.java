package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * 출처: https://www.acmicpc.net/problem/1181
 */
public class Problem1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());

		List<String> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(bf.readLine());
		}

		list.stream()
				.sorted(comparing(String::length)
						.thenComparing(String::compareTo))
				.distinct()
				.forEach(System.out::println);
	}
}
