package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처: https://www.acmicpc.net/problem/1062
 */
public class Problem1062 {

	private static List<Set<Character>> list;
	private static String[] alpha = {"b", "d", "e", "f", "g", "h", "j", "k", "l", "m",
			"o", "p", "q", "r", "s", "u", "v", "w", "x", "y", "z"};
	private static String[] choice;
	private static boolean[] isVisited;
	private static int K;
	private static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) {
			System.out.println(0);
			return;
		}
		K -= 5;


		String[] arr = new String[N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new HashSet<>());
		}

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().replaceAll("[antic]", "");

			for (int j = 0; j < arr[i].length(); j++) {
				list.get(i).add(arr[i].charAt(j));
			}
		}

		isVisited = new boolean[alpha.length];
		choice = new String[K];
		combination(0, 0);

		System.out.println(max);
	}

	private static void combination(int depth, int start) {
		if (depth == K) {
			int count = 0;

			for (Set<Character> s : list) {

				if (s.size() == 0) {
					count++;
					continue;
				}

				if (s.size() > K) {
					continue;
				}

				boolean have = true;
				List<String> choiceList = Arrays.asList(choice);
				for (Character c : s) {
					if (!choiceList.contains(String.valueOf(c))) {
						have = false;
						break;
					}
				}

				if (have) {
					count++;
				}
			}

			max = Math.max(max, count);
			return;
		}

		for (int i = start; i < alpha.length; i++) {
			if (isVisited[i]) {
				continue;
			}

			isVisited[i] = true;
			choice[depth] = alpha[i];
			combination(depth + 1, i + 1);
			isVisited[i] = false;
		}
	}
}
