package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.util.Comparator.*;

/**
 * 출처: https://www.acmicpc.net/problem/16930
 */
public class Problem16930 {

	private static int R;
	private static int C;
	private static int speed;
	private static int answer = -1;
	private static final int[] dr = {-1, 0, 1, 0}; // 위, 왼쪽, 아래, 오른쪽
	private static final int[] dc = {0, -1, 0, 1};
	private static int[][] map;
	private static int[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		speed = Integer.parseInt(st.nextToken());

		initiailze(br);

		st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken()) - 1;
		int c1 = Integer.parseInt(st.nextToken()) - 1;
		int r2 = Integer.parseInt(st.nextToken()) - 1;
		int c2 = Integer.parseInt(st.nextToken()) - 1;

		bfs(r1, c1, r2, c2);

		System.out.println(answer);
	}

	private static void bfs(int r1, int c1, int r2, int c2) {
		PriorityQueue<Node> pq = new PriorityQueue<>(comparingInt(n -> n.step));
		isVisited[r1][c1] = 0;
		pq.add(new Node(r1, c1, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.row == r2 && cur.col == c2) {
				answer = cur.step;
				return;
			}

			int nextStep = cur.step + 1;

			for (int i = 0; i < 4; i++) {
				for (int s = 1; s <= speed; s++) {
					int nr = cur.row + s * dr[i];
					int nc = cur.col + s * dc[i];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == 1) {
						break;
					}

					if (isVisited[nr][nc] == Integer.MAX_VALUE) {
						isVisited[nr][nc] = nextStep;
						pq.add(new Node(nr, nc, nextStep));
						continue;
					}

					if (isVisited[nr][nc] <= cur.step) {
						break;
					}
				}
			}
		}
	}

	private static void initiailze(BufferedReader br) throws IOException {
		map = new int[R][C];
		isVisited = new int[R][C];

		for (int r = 0; r < R; r++) {
			Arrays.fill(isVisited[r], Integer.MAX_VALUE);
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (input[c] == '.') {
					map[r][c] = 0;
				} else {
					map[r][c] = 1;
				}
			}
		}
	}

	private static class Node {
		int row;
		int col;
		int step;

		public Node(int row, int col, int step) {
			this.row = row;
			this.col = col;
			this.step = step;
		}
	}
}
