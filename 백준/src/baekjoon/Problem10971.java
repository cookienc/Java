package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/10971
 */
public class Problem10971 {

	private static int N;
	private static List<List<Integer>> map;
	private static boolean[] isVisited;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		isVisited = new boolean[N];
		map = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			map.add(new ArrayList<>());
		}

		initializeMap(br);

		for (int i = 0; i < N; i++) {
			isVisited = new boolean[N];
			int[] order = new int[N + 1];
			order[0] = i;
			dfs(0, i, 0, order);
		}
		System.out.println(min);
	}

	private static void dfs(int depth, int start, int preCost, int[] order) {

		if (depth == N && order[0] == order[N]) {
			min = Math.min(min, preCost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isVisited[i]) {
				continue;
			}
			Integer cost = map.get(start).get(i);
			if (cost == 0) {
				continue;
			}

			isVisited[i] = true;
			order[depth + 1] = i;
			dfs(depth + 1, i,preCost + cost, order.clone());
			isVisited[i] = false;
		}

	}

	private static void initializeMap(BufferedReader br) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
	}
}
