package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/81302
 */
public class CheckingSocialDistancing {
	static class Solution {

		private static int[] dRow = {1, -1, 0, 0};
		private static int[] dCol = {0, 0, 1, -1};
		private static boolean[][] isVisited;

		public int[] solution(String[][] places) {


			int[] answer = new int[5];
			Arrays.fill(answer, 1);

			for (int i = 0; i < 5; i++) {
				char[][] arr = new char[5][5];

				for (int j = 0; j < 5; j++) {
					for (int k = 0; k < 5; k++) {
						arr[j][k] = places[i][j].charAt(k);
					}
				}

				for (int j = 0; j < 5; j++) {
					boolean isItEnd = false;

					for (int k = 0; k < 5; k++) {
						if ('P' == arr[j][k]) {
							isVisited = new boolean[5][5];
							if (!dfs(j, k, arr)) {
								answer[i] = 0;
								isItEnd = true;
								break;
							}
						}
					}

					if (isItEnd) {
						break;
					}
				}
			}
			return answer;
		}

		private static boolean dfs(int row, int col, char[][] places) {

			boolean isRight = true;
			Queue<Node> queue = new LinkedList<>();

			isVisited[row][col] = true;
			queue.add(new Node(row, col, 0));

			while (!queue.isEmpty()) {

				boolean isItEnd = false;
				Node cur = queue.poll(); //1 0 1

				for (int i = 0; i < 4; i++) {
					int nextR = cur.row + dRow[i]; //1
					int nextC = cur.col + dCol[i]; //0

					if (nextR < 0 || nextC < 0 || nextR >= 5 || nextC >= 5) {
						continue;
					}

					if ('X' == places[nextR][nextC]) {
						continue;
					}

					if (isVisited[nextR][nextC]) {
						continue;
					}

					if ('P' == places[nextR][nextC]) {
						if (cur.cnt <= 1) {
							isItEnd = true;
							isRight = false;
							break;
						}
						continue;
					}

					isVisited[nextR][nextC] = true;
					queue.add(new Node(nextR, nextC, cur.cnt + 1));
				}

				if (isItEnd) {
					break;
				}
			}
			return isRight;
		}

		private static class Node {
			int row;
			int col;
			int cnt;

			public Node(int row, int col, int cnt) {
				this.row = row;
				this.col = col;
				this.cnt = cnt;
			}
		}
	}
}
