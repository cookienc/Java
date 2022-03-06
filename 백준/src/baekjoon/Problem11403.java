package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/11403
 */
public class Problem11403 {

	public static final String SPACE = " ";
	public static final String NEW_LINE = "\n";
	private static int[][] answer;
	private static boolean[][] isVisited;
	private static int[][] map;
	private static int N;
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		isVisited = new boolean[N][N];
		map = new int[N][N];


		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
					}
				}
			}
		}

		for (int[] i : map) {
			for (int j : i) {
				sb.append(j)
						.append(SPACE);
			}
			sb.append(NEW_LINE);
		}

		System.out.println(sb);
	}
}
