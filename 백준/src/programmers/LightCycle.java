package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/86052
 */
public class LightCycle {
	static class Solution {

		private static boolean[][][] isVisited;
		private static int[] dr = {-1, 0, 1, 0};
		private static int[] dc = {0, -1, 0, 1};
		private static int col;
		private static int row;

		public int[] solution(String[] grid) {

			row = grid.length;
			col = grid[0].length();

			isVisited = new boolean[row][col][4];// 0:상, 1:좌, 2:하, 3:우
			List<Integer> list = new ArrayList<>();

			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {

					for (int i = 0; i < 4; i++) {
						if (!isVisited[r][c][i]) {
							list.add(findCycle(r, c, i, grid));
						}
					}
				}
			}

			return list.stream()
					.sorted()
					.mapToInt(a -> a)
					.toArray();
		}

		private static int findCycle(int r, int c, int d, String[] grid) {
			int length = 0;

			while (true) {
				if (isVisited[r][c][d]) {
					break;
				}

				isVisited[r][c][d] = true;
				length++;

				if (grid[r].charAt(c) == 'L') {
					d = d == 3? 0 : (d + 1);
				} else if (grid[r].charAt(c) == 'R') {
					d = d == 0? 3 : (d - 1);
				}

				r = (r + dr[d] + row) % row;
				c = (c + dc[d] + col) % col;

			}

			return length;
		}

	}
}
