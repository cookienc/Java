package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1303
 */
public class Problem1303 {

	public static final boolean WHITE = false;
	public static final boolean BLUE = true;
	private static boolean[][] members;
	private static boolean[][] isVisited;
	private static int R;
	private static int C;
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		initializeMembers(br);

		int blue = 0;
		int white = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (isVisited[r][c]) {
					continue;
				}
				int count = bfs(r, c);

				if (members[r][c] == BLUE) {
					blue += Math.pow(count, 2);
				} else {
					white += Math.pow(count, 2);
				}
			}
		}

		System.out.println(white + " " + blue);
	}

	private static int bfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();

		int count = 1;
		boolean flag = members[r][c];
		isVisited[r][c] = true;

		q.add(new Node(r, c));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int cr = cur.row;
			int cc = cur.col;

			for (int i = 0; i < 4; i++) {
				int nr = cr + dr[i];
				int nc = cc + dc[i];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
					continue;
				}

				if (isVisited[nr][nc] || members[nr][nc] != flag) {
					continue;
				}

				isVisited[nr][nc] = true;
				count++;
				q.add(new Node(nr, nc));
			}
		}
		return count;
	}

	private static void initializeMembers(BufferedReader br) throws IOException {
		members = new boolean[R][C];
		isVisited = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			String[] member = br.readLine().split("");
			for (int c = 0; c < C; c++) {
				if ("W".equals(member[c])) {
					members[r][c] = WHITE;
				} else {
					members[r][c] = BLUE;
				}
			}
		}
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
