package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/12100
 */
public class Problem12100 {

	private static int max = Integer.MIN_VALUE;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[][] block = new int[N][N];
		StringTokenizer st;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				block[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, block);
		System.out.println(max);
	}

	private static void dfs(int depth, int[][] block) {

		if (depth == 5) {
			for (int[] i : block) {
				for (int num : i) {
//					System.out.print(num + " ");
					max = Math.max(num, max);
				}
//				System.out.println();
			}
//			System.out.println();
//			System.out.println();
			return;
		}

		for (int i = 0; i < 4; i++) {

			int[][] tmp = new int[N][N];
			for (int j = 0; j < N; j++) {
				tmp[j] = block[j].clone();
			}

			move(i, tmp);

			dfs(depth + 1, tmp);
		}
	}

	private static void move(int direction, int[][] block) {

		Queue<Integer> queue;
		switch (direction) {
			case 0: //상
				moveToTop(block);
				break;
			case 1: //하
				moveToBottom(block);
				break;
			case 2: //좌
				moveToLeft(block);
				break;
			case 3: //우
				moveToRight(block);
				break;
		}
	}

	private static void moveToTop(int[][] block) {
		Queue<Integer> queue;
		for (int c = 0; c < N; c++) {
			queue = new LinkedList<>();

			for (int r = 0; r < N; r++) {
				if (block[r][c] == 0) {
					continue;
				}
				queue.add(block[r][c]);
			}

			for (int r = 0; r < N; r++) {

				Integer num;
				if (!queue.isEmpty()) {
					num = queue.poll();
				} else {
					num = 0;
				}

				if ((!queue.isEmpty()) && ((int) queue.peek() == num)) {
					num += queue.poll();
				}

				block[r][c] = num;
			}
		}
	}

	private static void moveToBottom(int[][] block) {
		Queue<Integer> queue;
		for (int c = 0; c < N; c++) {
			queue = new LinkedList<>();

			for (int r = N - 1; r >= 0; r--) {
				if (block[r][c] == 0) {
					continue;
				}
				queue.add(block[r][c]);
			}

			for (int r = N - 1; r >= 0; r--) {

				Integer num;
				if (!queue.isEmpty()) {
					num = queue.poll();
				} else {
					num = 0;
				}

				if ((!queue.isEmpty()) && ((int) queue.peek() == num)) {
					num += queue.poll();
				}

				block[r][c] = num;
			}
		}
	}

	private static void moveToLeft(int[][] block) {
		Queue<Integer> queue;
		for (int r = 0; r < N; r++) {
			queue = new LinkedList<>();

			for (int c = 0; c < N; c++) {
				if (block[r][c] == 0) {
					continue;
				}
				queue.add(block[r][c]);
			}

			for (int c = 0; c < N; c++) {

				Integer num;
				if (!queue.isEmpty()) {
					num = queue.poll();
				} else {
					num = 0;
				}

				if ((!queue.isEmpty()) && ((int) queue.peek() == num)) {
					num += queue.poll();
				}

				block[r][c] = num;
			}
		}
	}

	private static void moveToRight(int[][] block) {
		Queue<Integer> queue;
		for (int r = 0; r < N; r++) {
			queue = new LinkedList<>();

			for (int c = N - 1; c >= 0; c--) {
				if (block[r][c] == 0) {
					continue;
				}
				queue.add(block[r][c]);
			}

			for (int c = N - 1; c >= 0; c--) {

				Integer num;
				if (!queue.isEmpty()) {
					num = queue.poll();
				} else {
					num = 0;
				}

				if ((!queue.isEmpty()) && ((int) queue.peek() == num)) {
					num += queue.poll();
				}

				block[r][c] = num;
			}
		}
	}
}
