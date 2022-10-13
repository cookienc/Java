package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/5212
 */
public class Problem5212 {

	private static int[][] map;
	private static Queue<Node> q;
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	private static int R;
	private static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		q = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			char[] info = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (info[c] == '.') {
					map[r][c] = 0;
					continue;
				}
				map[r][c] = 1;

				q.add(new Node(r, c));
			}
		}

		Stack<Node> stack = new Stack<>();
		after(stack);

		while (!stack.isEmpty()) {
			Node pop = stack.pop();
			map[pop.r][pop.c] = 0;
		}

		int rStart = R;
		int cStart = C;
		int rEnd = 0;
		int cEnd = 0;
		for (int r = 0; r < R; r++) {
			boolean sea = true;

			for (int c = 0; c < C; c++) {
				if (map[r][c] == 1) {
					cStart = Math.min(cStart, c);
					cEnd = Math.max(cEnd, c);
					sea = false;
				}
			}

			if (!sea) {
				rStart = Math.min(rStart, r);
				rEnd = Math.max(rEnd, r);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int r = rStart; r <= rEnd; r++) {
			for (int c = cStart; c <= cEnd; c++) {
				if (map[r][c] == 0 ) {
					sb.append(".");
					continue;
				}
				sb.append("X");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void after(Stack<Node> stack) {
		while (!q.isEmpty()) {
			Node cur = q.poll();

			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					cnt++;
					continue;
				}

				if (map[nr][nc] == 1) {
					continue;
				}

				cnt++;
			}

			if (cnt >= 3) {
				stack.push(new Node(cur.r, cur.c));
			}
		}
	}

	private static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
