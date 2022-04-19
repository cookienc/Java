package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/92344?language=java
 */
public class UndestroyedBuilding {
	class Solution {
		public int solution(int[][] board, int[][] skill) {

			int row = board.length;
			int col = board[0].length;

			for (int i = 0; i < skill.length; i++) {
				int type = skill[i][0];
				int r1 = skill[i][1];
				int c1 = skill[i][2];
				int r2 = skill[i][3];
				int c2 = skill[i][4];
				int degree = skill[i][5];

				if (type == 1) {
					for (int r = r1; r <= r2; r++) {
						for (int c = c1; c <= c2; c++) {
							board[r][c] -= degree;
						}
					}
					continue;
				}
				for (int r = r1; r <= r2; r++) {
					for (int c = c1; c <= c2; c++) {
						board[r][c] += degree;
					}
				}
			}
			int answer = 0;
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (board[r][c] > 0) {
						answer++;
					}
				}
			}

			return answer;
		}
	}
}
