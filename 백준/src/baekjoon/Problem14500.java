package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/14500
 */
public class Problem14500 {

	private static int[][] map;
	public static final boolean F = false;
	public static final boolean T = true;
	private static int answer = Integer.MIN_VALUE;
	private static int count = 0;
	private static boolean[][][] tetromino = {
		{
				{T, F, F, F},
				{T, F, F, F},
				{T, F, F, F},
				{T, F, F, F}
		}, {
				{T, T, T, T},
				{F, F, F, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{T, T, F, F},
				{T, T, F, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{T, T, F, F},
				{F, T, T, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{F, T, F, F},
				{T, T, F, F},
				{T, F, F, F},
				{F, F, F, F}
		}, {
				{F, T, T, F},
				{T, T, F, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{T, F, F, F},
				{T, T, F, F},
				{F, T, F, F},
				{F, F, F, F}
		}, {
				{T, F, F, F},
				{T, F, F, F},
				{T, T, F, F},
				{F, F, F, F}
		}, {
				{T, T, T, F},
				{T, F, F, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{T, T, F, F},
				{F, T, F, F},
				{F, T, F, F},
				{F, F, F, F}
		}, {
				{F, F, T, F},
				{T, T, T, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{F, T, F, F},
				{F, T, F, F},
				{T, T, F, F},
				{F, F, F, F}
		}, {
				{T, F, F, F},
				{T, T, T, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{T, T, F, F},
				{T, F, F, F},
				{T, F, F, F},
				{F, F, F, F}
		}, {
				{T, T, T, F},
				{F, F, T, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{T, T, T, F},
				{F, T, F, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{F, T, F, F},
				{T, T, T, F},
				{F, F, F, F},
				{F, F, F, F}
		}, {
				{F, T, F, F},
				{T, T, F, F},
				{F, T, F, F},
				{F, F, F, F}
		}, {
				{T, F, F, F},
				{T, T, F, F},
				{T, F, F, F},
				{F, F, F, F}
		}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N + 3][M + 3];

		initializeMap(bf, N, M);

		for (int k = 0; k < 19; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					for (int n = 0; n < 4; n++) {
						for (int m = 0; m < 4; m++) {
							if (tetromino[k][n][m]) {
								count += map[n + i][m + j];
							}
						}
					}
					answer = Math.max(answer, count);
					count = 0;
				}
			}
		}
		System.out.println(answer);
	}

	private static void initializeMap(BufferedReader bf, int N, int M) throws IOException {
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = N; i < N + 3; i++) {
			for (int j = 0; j < M + 3; j++) {
				map[i][j] = Integer.MIN_VALUE;
			}
		}
		for (int i = 0; i < N + 3; i++) {
			for (int j = M; j < M + 3; j++) {
				map[i][j] = Integer.MIN_VALUE;
			}
		}
	}
}
