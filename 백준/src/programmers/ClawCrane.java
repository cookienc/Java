package programmers;

import java.util.Stack;

public class ClawCrane {
	class Solution {

		public int solution(int[][] board, int[] moves) {
			int count = 0;
			Stack<Integer> box = new Stack<>();

			for (int move : moves) {
				count += crane(move - 1, board, box);
			}

			return count;
		}

		private int crane(int line, int[][] board, Stack<Integer> box) {
			int count = 0;
			int top = 0;

			if (box.size() != 0) {
				top = box.peek();
			}

			for (int i = 0; i < board.length; i++) {
				if (board[i][line] != 0) {
					if (top == board[i][line]) {
						box.pop();
						board[i][line] = 0;
						count += 2;
						break;
					}

					box.push(board[i][line]);
					board[i][line] = 0;
					break;
				}
			}
			return count;
		}
	}
}
