package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/18808
 */
public class Problem18808 {
	private static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int[][] sticker = new int[R][C];

			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					sticker[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 4; i++) {
				if (check(sticker)) {
					break;
				}
				sticker = getRotate(sticker);
			}
		}

		int sum = 0;
		for (int[] b : board) {
			for (int i : b) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	private static boolean check(int[][] sticker) {
		for (int r = 0; r <= board.length - sticker.length; r++) {
			for (int c = 0; c <= board[0].length - sticker[0].length; c++) {
				if (compare(r, c, sticker)) {
					attach(r, c, sticker);
					return true;
				}
			}
		}
		return false;
	}

	private static int[][] getRotate(int[][] sticker) {
		int R = sticker.length;
		int C = sticker[0].length;

		int[][] rotate = new int[C][R];
		for (int r = R - 1; r >= 0; r--) {
			for (int c = 0; c < C; c++) {
				rotate[c][R - 1 - r] = sticker[r][c];
			}
		}
		return rotate;
	}

	private static void attach(int r, int c, int[][] sticker) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j <sticker[0].length; j++) {
				if (sticker[i][j] == 0) {
					continue;
				}
				board[r + i][c + j] = sticker[i][j];
			}
		}
	}

	private static boolean compare(int r, int c, int[][] sticker) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (sticker[i][j] == 1 && board[i + r][j + c] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
