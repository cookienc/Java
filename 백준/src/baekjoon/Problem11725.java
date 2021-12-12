package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11725
 * 유형: dfs, 그래프
 */

public class Problem11725 {

	private static List<Integer>[] map;
	private static int[] parents;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		StringTokenizer stringTokenizer;

		int n = Integer.parseInt(bufferedReader.readLine());

		map = new ArrayList[n + 1];
		isVisited = new boolean[n + 1];
		parents = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			map[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int a = Integer.parseInt(stringTokenizer.nextToken());
			int b = Integer.parseInt(stringTokenizer.nextToken());

			map[a].add(b);
			map[b].add(a);
		}

		for (int i = 1; i < n + 1; i++) {
			Collections.sort(map[i]);
		}

		dfs(1);

		for (int i = 2; i < parents.length; i++) {
			stringBuilder.append(parents[i])
					.append("\n");
		}

		System.out.println(stringBuilder);
	}

	private static void dfs(int i) {
		if (isVisited[i]) {
			return;
		}

		isVisited[i] = true;

		for (int ii : map[i]) {
			if (!isVisited[ii]) {
				parents[ii] = i;
				dfs(ii);
			}
		}
	}
}
