package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/92343
 */
public class SheepAndWolves {
	public static void main(String[] args) {
		int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
		int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};
		System.out.println(Solution.solution(info, edges));
	}

	static class Solution {
		private static List<List<Integer>> graph;
		private static int max = 0;
		private static boolean[] checked;

		public static int solution(int[] info, int[][] edges) {

			checked = new boolean[info.length];
			graph = new ArrayList<>();
			for (int i = 0; i < info.length; i++) {
				graph.add(new ArrayList<>());
			}

			for (int[] edge : edges) {
				graph.get(edge[0]).add(edge[1]);
			}

			List<Integer> visited = new ArrayList<>();

			dfs(0, 0, 0, info, visited);

			return max;
		}

		private static void dfs(int index, int sheep, int wolf, int[] info, List<Integer> visited) {
			if (checked[index]) {
				return;
			}

			sheep += info[index] ^ 1;
			wolf += info[index];

			if (wolf >= sheep) {
				return;
			}
			max = Math.max(max, sheep);

			List<Integer> vis = new ArrayList<>();
			vis.addAll(visited);

			vis.addAll(graph.get(index));

			for (Integer i : vis) {
				if (checked[i]) {
					continue;
				}
				checked[index] = true;
				dfs(i, sheep, wolf, info, vis);
				checked[index] = false;
			}
		}
	}
}
