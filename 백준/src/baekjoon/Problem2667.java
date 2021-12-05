package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 출처 : https://www.acmicpc.net/problem/2667
 *
 * TODO 1. 단지 입력 nxn
 * 		2. 단지 출력 : 총 단지 수, 단지 별 가구 수(오름차순)
 * 		3. 단지 찾는 알고리즘 -> bfs
 */
public class Problem2667 {

	private static int[][] map;
	private static boolean[][] isVisited;
	private static int count = 0;
	private static int n = 0;
	private static int numberOfMember = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();

		n = Integer.parseInt(bufferedReader.readLine());

		map = new int[n + 1][n + 1];
		isVisited = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			String input = bufferedReader.readLine();
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.valueOf(input.charAt(j - 1) - '0');
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 0) {
					isVisited[i][j] = true;
					continue;
				}

				if (!isVisited[i][j]) {
					count++;
					bfs(i, j);
					stringBuilder.append(numberOfMember)
							.append("\n");
				}
			}
		}
		System.out.println(count);
		System.out.println(stringBuilder);

	}

	private static void bfs(int i, int j) {

		numberOfMember = 0;

		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();

		isVisited[i][j] = true;
		queueX.add(i);
		queueY.add(j);

		while (!queueX.isEmpty()) {

			numberOfMember++;

			int tempX = queueX.remove();
			int tempY = queueY.remove();

			int up = tempY - 1;
			int down = tempY + 1;
			int left = tempX - 1;
			int right = tempX + 1;

			if (left > 1) {
				if (((map[left][tempY] == 1) && (isVisited[left][tempY] == false))) {
					isVisited[left][tempY] = true;
					queueX.add(left);
					queueY.add(tempY);
					map[left][tempY] = 3;
				}
			}

			if (right < n + 1) {
				if (((map[right][tempY] == 1) && (isVisited[right][tempY] == false))) {
					isVisited[right][tempY] = true;
					queueX.add(right);
					queueY.add(tempY);
					map[right][tempY] = 3;
				}
			}

			if (down < n + 1) {
				if (((map[tempX][down] == 1) && (isVisited[tempX][down] == false))) {
					isVisited[tempX][down] = true;
					queueX.add(tempX);
					queueY.add(down);
					map[tempX][down] = 3;
				}
			}

			if (up > 1) {
				if (((map[tempX][up] == 1) && (isVisited[tempX][up] == false))) {
					isVisited[tempX][up] = true;
					queueX.add(tempX);
					queueY.add(up);
					map[tempX][up] = 3;
				}
			}
		}

	}
}
