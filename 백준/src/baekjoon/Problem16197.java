package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.util.Comparator.*;

/**
 * 출처: https://www.acmicpc.net/problem/16197
 */
public class Problem16197 {

	private static int[][] map;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};

	private static int R;
	private static int C;
	private static int answer;

	private static PriorityQueue<Node> pq;
	private static boolean[][][][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		Stack<int[]> stack = new Stack<>();
		for (int r = 0; r < R; r++) {
			char[] word = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (word[c] == 'o') {
					map[r][c] = 1;
					stack.push(new int[]{r, c});
					continue;
				}

				if (word[c] == '.') {
					map[r][c] = 1; // 빈칸
					continue;
				}

				map[r][c] = -1; // 벽
			}
		}
		int[] first = stack.pop();
		int[] second = stack.pop();
		pq = new PriorityQueue<>(comparingInt(n -> n.cnt));
		isVisited = new boolean[R][C][R][C];
		isVisited[first[0]][first[1]][second[0]][second[1]] = true;
		pq.add(new Node(first[0], first[1], second[0], second[1], 0, 0));

		dfs();

		if (answer == 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void dfs() {

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.cnt >= 10) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr1 = cur.r1 + dr[i];
				int nc1 = cur.c1 + dc[i];
				int nr2 = cur.r2 + dr[i];
				int nc2 = cur.c2 + dc[i];

				boolean first = false;
				boolean second = false;

				if (doDie(nr1, nc1)) {
					first = true;
				}

				if (doDie(nr2, nc2)) {
					second = true;
				}

				if (first && second) {
					continue;
				}

				if (first || second) {
					answer = cur.cnt + 1;
					return;
				}

				if (map[nr1][nc1] == -1) {
					nr1 = cur.r1;
					nc1 = cur.c1;
				}

				if (map[nr2][nc2] == -1) {
					nr2 = cur.r2;
					nc2 = cur.c2;
				}

				if (isVisited[nr1][nc1][nr2][nc2]) {
					continue;
				}

				isVisited[nr1][nc1][nr2][nc2] = true;
				pq.add(new Node(nr1, nc1, nr2, nc2, cur.cnt + 1, 0));
			}
		}
	}

	private static boolean doDie(int nr, int nc) {
		return nr < 0 || nc < 0 || nr >= R || nc >= C;
	}

	private static class Node {
		int r1;
		int c1;
		int r2;
		int c2;
		int cnt;
		int die;

		public Node(int r1, int c1, int r2, int c2, int cnt, int die) {
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.cnt = cnt;
			this.die = die;
		}
	}
}
