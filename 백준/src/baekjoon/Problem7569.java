package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/7569
 */
public class Problem7569 {

	private static int[][][] tomato;
	private static Queue<int[]> queue;
	private static boolean[][][] isVisited;
	private static int[] dx = {1, -1, 0, 0, 0, 0};
	private static int[] dy = {0, 0, 1, -1, 0, 0};
	private static int[] dz = {0, 0, 0, 0, 1, -1};
	private static int M;
	private static int N;
	private static int H;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		tomato = new int[N][M][H];
		isVisited = new boolean[N][M][H];
		queue = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(bf.readLine());
				for (int m = 0; m < M; m++) {
					int value = Integer.parseInt(st.nextToken());
					tomato[n][m][h] = value;

					if (value == 1) {
						queue.add(new int[]{n, m, h});
						isVisited[n][m][h] = true;
					}
				}
			}
		}
		bfs();

		if (findZero()) {
			System.out.println(-1);
			return;
		}

		System.out.println(findMax() - 1);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int n = queue.peek()[0];
			int m = queue.peek()[1];
			int h = queue.peek()[2];
			queue.poll();

			for (int i = 0; i < 6; i++) {
				int nextN = n + dy[i];
				int nextM = m + dx[i];
				int nextH = h + dz[i];

				if (isNotRange(nextN, nextM, nextH) || isVacancy(nextN, nextM, nextH)
						|| isVisited[nextN][nextM][nextH]) {
					continue;
				}
				queue.add(new int[]{nextN, nextM, nextH});
				isVisited[nextN][nextM][nextH] = true;
				tomato[nextN][nextM][nextH] = tomato[n][m][h] + 1;
			}
		}
	}

	private static boolean isVacancy(int nextN, int nextM, int nextH) {
		return tomato[nextN][nextM][nextH] == -1;
	}

	private static boolean isNotRange(int nextN, int nextM, int nextH) {
		return nextN < 0 || nextM < 0 || nextH < 0 || nextN >= N || nextM >= M || nextH >= H;
	}

	private static boolean findZero() {
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (tomato[n][m][h] == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static int findMax() {

		int max = 0;

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					max = Math.max(tomato[n][m][h], max);
				}
			}
		}
		return max;
	}
}
