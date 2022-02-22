package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1764
 */
public class Problem1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> notHear = new HashSet<>();
		Set<String> notWatch = new HashSet<>();

		for (int i = 0; i < N; i++) {
			notHear.add(bf.readLine());
		}

		for (int i = 0; i < M; i++) {
			notWatch.add(bf.readLine());
		}

		notHear.retainAll(notWatch);

		System.out.println(notHear.size());
		notHear.stream()
				.sorted(Comparator.naturalOrder())
				.forEach(System.out::println);
	}
}
