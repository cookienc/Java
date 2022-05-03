package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15683
 */
public class Problem15683 {

	private static int[][] map;
	private static boolean[] isVisited;
	private static List<Node> cctv;
	private static int size;
	private static int R;
	private static int C;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		cctv = new ArrayList<>();
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				int num = Integer.parseInt(st.nextToken());
				map[r][c] = num;

				if (num == 0 || num == 6) {
					continue;
				}
				cctv.add(new Node(r, c, num));
			}
		}
		size = cctv.size();
		isVisited = new boolean[size];
		dfs(0, 0, map);

		System.out.println(min);
	}

	private static void dfs(int depth, int start, int[][] map) {

		if (depth == size) {
			int cnt = 0;
			for (int[] m : map) {
				for (int i : m) {
					if (i == 0) {
						cnt++;
					}
				}
			}
			min = Math.min(min, cnt);
			return;
		}

		for (int i = start; i < size; i++) {
			if (isVisited[i]) {
				continue;
			}
			isVisited[i] = true;
			Node tv = cctv.get(i);

			int[][] tmp = new int[R][C];
			switch (tv.type) {
				case 1:
					//4번
					for (int j = 0; j < 4; j++) {
						tmp = arraysCopy(map);
						moveTypeOne(j, tmp, tv);
						dfs(depth + 1, i + 1, tmp);
					}
					break;

				case 2:
					//2번
					for (int j = 0; j < 2; j++) {
						tmp = arraysCopy(map);
						moveTypeTwo(j, tmp, tv);
						dfs(depth + 1, i + 1, tmp);
					}
					break;

				case 3:
					//4번
					for (int j = 0; j < 4; j++) {
						tmp = arraysCopy(map);
						moveTypeThree(j, tmp, tv);
						dfs(depth + 1, i + 1, tmp);
					}
					break;

				case 4:
					//4번
					for (int j = 0; j < 4; j++) {
						tmp = arraysCopy(map);
						moveTypeFour(j, tmp, tv);
						dfs(depth + 1, i + 1, tmp);
					}
					break;

				case 5:
					//1번
					tmp = arraysCopy(map);
					moveTypeFive(tmp, tv);
					dfs(depth + 1, i + 1, tmp);
					break;
			}
			isVisited[i] = false;
		}
	}

	private static void watchRight(int[][] map, Node cctv) {
		int row = cctv.row;
		int col = cctv.col;

		for (int c = col + 1; c < C; c++) {
			if (map[row][c] == 6) {
				break;
			}

			if (map[row][c] != 0) {
				continue;
			}

			map[row][c] = 9;
		}
	}

	private static void watchLeft(int[][] map, Node cctv) {
		int row = cctv.row;
		int col = cctv.col;

		for (int c = col - 1; c >= 0; c--) {
			if (map[row][c] == 6) {
				break;
			}

			if (map[row][c] != 0) {
				continue;
			}

			map[row][c] = 9;
		}
	}

	private static void watchUp(int[][] map, Node cctv) {
		int row = cctv.row;
		int col = cctv.col;

		for (int r = row - 1; r >= 0; r--) {
			if (map[r][col] == 6) {
				break;
			}

			if (map[r][col] != 0) {
				continue;
			}

			map[r][col] = 9;
		}
	}

	private static void watchDown(int[][] map, Node cctv) {
		int row = cctv.row;
		int col = cctv.col;

		for (int r = row + 1; r < R; r++) {
			if (map[r][col] == 6) {
				break;
			}

			if (map[r][col] != 0) {
				continue;
			}

			map[r][col] = 9;
		}
	}

	private static int[][] arraysCopy(int[][] map) {
		int[][] tmp = new int[R][C];

		for (int k = 0; k < R; k++) {
			tmp[k] = map[k].clone();
		}
		return tmp;
	}

	private static void moveTypeOne(int direction, int[][] map, Node tv) {

		switch (direction) {
			case 0:
				watchUp(map, tv);
				break;
			case 1:
				watchDown(map, tv);
				break;
			case 2:
				watchLeft(map, tv);
				break;
			case 3:
				watchRight(map, tv);
				break;
		}
	}

	private static void moveTypeTwo(int direction, int[][] map, Node tv) {

		switch (direction) {
			case 0:
				watchUp(map, tv);
				watchDown(map, tv);
				break;
			case 1:
				watchLeft(map, tv);
				watchRight(map, tv);
				break;
		}
	}

	private static void moveTypeThree(int direction, int[][] map, Node tv) {

		switch (direction) {
			case 0:
				watchUp(map, tv);
				watchLeft(map, tv);
				break;
			case 1:
				watchDown(map, tv);
				watchLeft(map, tv);
				break;
			case 2:
				watchUp(map, tv);
				watchRight(map, tv);
				break;
			case 3:
				watchDown(map, tv);
				watchRight(map, tv);
				break;
		}
	}

	private static void moveTypeFour(int direction, int[][] map, Node tv) {

		switch (direction) {
			case 0:
				watchDown(map, tv);
				watchLeft(map, tv);
				watchRight(map, tv);
				break;
			case 1:
				watchUp(map, tv);
				watchLeft(map, tv);
				watchRight(map, tv);
				break;
			case 2:
				watchUp(map, tv);
				watchDown(map, tv);
				watchRight(map, tv);
				break;
			case 3:
				watchUp(map, tv);
				watchDown(map, tv);
				watchLeft(map, tv);
				break;
		}
	}

	private static void moveTypeFive(int[][] map, Node tv) {

		watchUp(map, tv);
		watchLeft(map, tv);
		watchRight(map, tv);
		watchDown(map, tv);
	}

	public static class Node {
		int row;
		int col;
		int type;

		public Node(int row, int col, int type) {
			this.row = row;
			this.col = col;
			this.type = type;
		}
	}

}

