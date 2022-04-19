package programmers;

/**
 * 출처: https://programmers.co.kr/learn/courses/30/lessons/92344?language=java
 */
public class UndestroyedBuilding {
	static class Solution {
		private static int[][] sum;
		private static int row;
		private static int col;

		public static int solution(int[][] board, int[][] skill) {
			row = board.length;
			col = board[0].length;

			sum = new int[row + 1][col + 1];
			for (int[] s : skill) {
				int r1 = s[1];
				int c1 = s[2];
				int r2 = s[3];
				int c2 = s[4];
				int degree = s[5] * (s[0] == 1 ? -1 : 1);

				sum[r1][c1] += degree;
				sum[r1][c2 + 1] += (degree * -1);
				sum[r2 + 1][c1] += (degree * -1);
				sum[r2 + 1][c2 + 1] += degree;
			}
			operate();


			int answer = 0;
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (board[r][c] + sum[r][c] > 0) answer++;
				}
			}
			return answer;
		}

		// 누적합
		private static void operate() {

			for (int r = 1; r < row; r++) {
				for (int c = 0; c < col; c++) {
					sum[r][c] += sum[r - 1][c];
				}
			}

			for (int c = 1; c < col; c++) {
				for (int r = 0; r < row; r++) {
					sum[r][c] += sum[r][c - 1];
				}
			}
		}
	}
}
