package programmers;

import java.util.PriorityQueue;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/86971
 */
public class SplitThePowerGridInTwo {
	static class Solution {

		private static int[][] map;
		private static int answer = Integer.MAX_VALUE;

		public int solution(int n, int[][] wires) {

			initialize(n, wires);

			for (int i = 0; i < wires.length; i++) {
				bfs(wires, i);
			}


			return answer;
		}

		private static void bfs(int[][] wires, int index) {

			int from = wires[index][0] - 1;
			int to = wires[index][1] - 1;

			map[from][to] = 0;
			map[to][from] = 0;

			boolean[] isVisited = new boolean[map.length];
			PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.cnt - n1.cnt);
			pq.add(new Node(0, 1));
			isVisited[0] = true;
			int max = -1;

			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				max = Math.max(max, cur.cnt);

				for (int i = 0; i < map.length; i++) {
					if (i == cur.v) {
						continue;
					}

					if (map[cur.v][i] == 0 || isVisited[i]) {
						continue;
					}

					isVisited[i] = true;
					pq.add(new Node(i, cur.cnt + 1));
				}
			}
			int connection = 0;
			for (boolean b : isVisited) {
				if (b) {
					connection++;
				}
			}

			answer = Math.min(answer, Math.abs(map.length - 2 * connection));

			map[from][to] = 1;
			map[to][from] = 1;
		}

		private static void initialize(int n, int[][] wires) {

			map = new int[n][n];

			for (int[] wire : wires) {
				int from = wire[0] - 1;
				int to = wire[1] - 1;

				map[from][to] = 1;
				map[to][from] = 1;
			}
		}

		private static class Node {
			int v;
			int cnt;

			Node(int v, int cnt) {
				this.v = v;
				this.cnt = cnt;
			}
		}
	}
}
