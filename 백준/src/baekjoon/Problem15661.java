package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/15661
 */
public class Problem15661 {
	private static int[][] arr;
	private static int N;
	private static int end;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		StringTokenizer st;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 1; i <= (N / 2); i++) {
			end = i;
			dfs(0, 0, 0);
		}
		System.out.println(min);
	}

	private static void dfs(int depth, int start, int flag) {
		if (depth == end) {
			min = Math.min(min, diff(flag));
			return;
		}

		for (int i = start; i < N; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			}

			dfs(depth + 1, i, flag | (1 << i));
		}
	}

	private static int diff(int flag) {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (((flag & (1 << i)) != 0) && ((flag & (1 << j)) != 0)) {
					start += arr[i][j] + arr[j][i];
				} else if (((flag & (1 << i)) == 0) && ((flag & (1 << j)) == 0)) {
					link += arr[i][j] + arr[j][i];
				}
			}
		}
		return Math.abs(start - link);
	}
}
