package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/13460
 * 참고: https://loosie.tistory.com/312
 */
public class Problem13460 {

	public static final char HOLE = 'O';
	public static final char WALL = '#';
	private static int R;
	private static int C;
	private static char[][] map;
	private static boolean[][][][] checked;
	private static int min = Integer.MAX_VALUE;
	private static int[] dr = {1, -1, 0, 0};
	private static int[] dc = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		checked = new boolean[R][C][R][C];

		int rR = 0;
		int rC = 0;
		int bR = 0;
		int bC = 0;

		for (int r = 0; r < R; r++) {
			char[] arr = br.readLine().toCharArray();
			for (int c = 0; c < C ; c++) {
				map[r][c] = arr[c];
				if (arr[c] == 'R') {
					rR = r;
					rC = c;
				} else if (arr[c] == 'B') {
					bR = r;
					bC = c;
				}
			}
		}

		bfs(rR, rC, bR, bC, 0);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void bfs(int rx, int ry, int bx, int by, int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{rx, ry, bx, by, cnt});
		checked[rx][ry][bx][by] = true;

		while (!queue.isEmpty()) {
			int[] marble = queue.poll();
			int count = marble[4];

			if (count >= 10) {
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nRr = marble[0];
				int nRc = marble[1];
				int nBr = marble[2];
				int nBc = marble[3];

				// 빨간 구슬 이동
				while (map[nRr + dr[i]][nRc + dc[i]] != WALL) {
					nRr += dr[i];
					nRc += dc[i];
					if (map[nRr][nRc] == HOLE) {
						break;
					}
				}

				// 파란 구슬 이동
				while (map[nBr + dr[i]][nBc + dc[i]] != WALL) {
					nBr += dr[i];
					nBc += dc[i];
					if (map[nBr][nBc] == HOLE) {
						break;
					}
				}

				// 파란 구슬이 구멍에 들어갔을 때
				if (map[nBr][nBc] == HOLE) {
					continue;
				}

				// 빨간 구슬만 들어갔을 경우
				if (map[nRr][nRc] == HOLE) {
					min = Math.min(min, count + 1);
					return;
				}

				// 빨간 파랑 서로 같은 위치에 있을 때
				if (nRr == nBr && nRc == nBc && map[nRr][nRc] != HOLE) {
					int red_move = Math.abs(nRr - marble[0]) + Math.abs(nRc - marble[1]);
					int blue_move = Math.abs(nBr - marble[2]) + Math.abs(nBc - marble[3]);

					// 파란 공이 더 빨리 도착한 경우
					if (red_move > blue_move) {
						nRr -= dr[i];
						nRc -= dc[i];
					} else { // 빨간 공이 더 빨리 도착한 경우
						nBr -= dr[i];
						nBc -= dc[i];
					}
				}

				if (!checked[nRr][nRc][nBr][nBc]) {
					checked[nRr][nRc][nBr][nBc] = true;
					queue.add(new int[]{nRr, nRc, nBr, nBc, count + 1});
				}
			}
		}
	}
}