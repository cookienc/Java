package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TheShortestDistanceOfGameMap {
	static class Solution {

		private static int[][] map;
		private static boolean[][] isVisited;
		private static int R;
		private static int C;
		private static final int[] dr = {-1, 0, 1, 0};
		private static final int[] dc = {0, -1, 0, 1};
		private static int answer = Integer.MAX_VALUE;

		public int solution(int[][] maps) {
			map = maps;
			R = maps.length;
			C = maps[0].length;
			isVisited = new boolean[R][C];

			bfs(new Position(0, 0, 1));

			if (answer == Integer.MAX_VALUE) {
				return -1;
			}

			return answer;
		}

		private static void bfs(Position pos) {
			PriorityQueue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.dis));
			pq.add(pos);
			isVisited[0][0] = true;

			while(!pq.isEmpty()) {
				Position cur = pq.poll();
				int curR = cur.r;
				int curC = cur.c;
				int curDis = cur.dis;

				if (curR == R - 1 && curC == C - 1) {
					answer = Math.min(answer, curDis);
					continue;
				}

				for (int i = 0; i < 4; i++) {
					int nR = curR + dr[i];
					int nC = curC + dc[i];

					if (outOfRange(nR, nC) || isItWall(nR, nC) || isVisited[nR][nC]) {
						continue;
					}

					isVisited[nR][nC] = true;
					pq.add(new Position(nR, nC, curDis + 1));
				}
			}
		}

		private static boolean outOfRange(int r, int c) {
			return r < 0 || c < 0 || r >= R || c >= C;
		}

		private static boolean isItWall(int r, int c) {
			return map[r][c] == 0;
		}

		private static class Position {
			int r;
			int c;
			int dis;

			public Position(int r, int c, int dis) {
				this.r = r;
				this.c = c;
				this.dis = dis;
			}
		}
	}
}
