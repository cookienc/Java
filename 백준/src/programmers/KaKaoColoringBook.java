package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class KaKaoColoringBook {
	static class Solution {

		private static boolean[][] isVisited;
		private static int[] dy = {1, -1, 0, 0};
		private static int[] dx = {0, 0, 1, -1};

		public int[] solution(int m, int n, int[][] picture) {
			int y = picture.length;
			int x = picture[0].length;
			isVisited = new boolean[y][x];

			int sameArea = 0;
			int maxSize = Integer.MIN_VALUE;
			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					if (!isVisited[i][j] && picture[i][j] != 0) {
						sameArea++;
						maxSize = Math.max(maxSize ,bfs(i, j, picture));
					}
				}
			}
			return new int[]{sameArea, maxSize};
		}

		private static int bfs(int y, int x, int[][] picture) {
			int maxY = picture.length;
			int maxX = picture[0].length;

			int areaSize = 1;
			Queue<Node> q = new LinkedList<>();

			isVisited[y][x] = true;
			int color = picture[y][x];
			q.offer(new Node(y, x));

			while (!q.isEmpty()) {
				Node cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nextY = cur.y + dy[i];
					int nextX = cur.x + dx[i];

					if (nextY < 0 || nextX < 0
							|| nextY >= maxY || nextX >= maxX ) {
						continue;
					}

					if (isVisited[nextY][nextX] ||
							(color != picture[nextY][nextX])) {
						continue;
					}

					isVisited[nextY][nextX] = true;
					areaSize++;
					q.offer(new Node(nextY, nextX));
				}
			}
			return areaSize;
		}

		private static class Node {
			int y;
			int x;

			public Node(int y, int x) {
				this.y = y;
				this.x = x;
			}
		}
	}
}
