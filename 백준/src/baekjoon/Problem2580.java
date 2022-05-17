package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/2580
 */
public class Problem2580 {

	public static final int SIZE = 9;
	private static int[][] board;
	private static List<Node> list;
	private static int count = 0;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[SIZE][SIZE];

		StringTokenizer st;
		list = new LinkedList<>();
		for (int r = 0; r < SIZE; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < SIZE; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
				if (board[r][c] == 0) {
					list.add(new Node(r, c));
				}
			}
		}
		count = list.size();
		dfs(0);
	}

	private static void dfs(int depth) {
		if (depth == count) {
			for (int r = 0; r < SIZE; r++) {
				for (int c = 0; c < SIZE; c++) {
					sb.append(board[r][c] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
			return;
		}

		Node node = list.get(depth);
		int r = node.row;
		int c = node.col;
		for (int i = 1; i <= 9; i++) {
			board[r][c] = i;
			if (!check(r, c)) {
				board[r][c] = 0;
				continue;
			}
			dfs(depth + 1);
			board[r][c] = 0;
		}
	}

	private static boolean check(int r, int c) {
		return squareCheck(r, c) && rowCheck(r, c) && columnCheck(r, c);
	}

	private static boolean squareCheck(int r, int c) {
		int rowL = r / 3 * 3;
		int rowH = r / 3 * 3 + 3;
		int colL = c / 3 * 3;
		int colH = c / 3 * 3 + 3;

		boolean[] hasNumber = new boolean[10];

		for (int row = rowL; row < rowH; row++) {
			for (int col = colL; col < colH; col++) {
				int number = board[row][col];

				if (number == 0) {
					continue;
				}

				if (hasNumber[number]) {
					return false;
				}

				hasNumber[number] = true;
			}
		}

		return true;
	}

	private static boolean columnCheck(int r, int c) {

		boolean[] hasNumber = new boolean[10];

		for (int i = 0; i < SIZE; i++) {
			int number = board[i][c];

			if (number == 0) {
				continue;
			}

			if (hasNumber[number]) {
				return false;
			}
			hasNumber[number] = true;
		}

		return true;
	}

	private static boolean rowCheck(int r, int c) {

		boolean[] hasNumber = new boolean[10];

		for (int i = 0; i < SIZE; i++) {
			int number = board[r][i];

			if (number == 0) {
				continue;
			}

			if (hasNumber[number]) {
				return false;
			}
			hasNumber[number] = true;
		}

		return true;
	}
	private static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
