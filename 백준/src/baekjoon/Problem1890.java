package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1890 {

	private static int[][] dp;
	private static int[][] array;
	private static int count = 0;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());

		dp = new int[N + 1][N + 1];
		array = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 1);

		System.out.println(count);
	}

	private static void dfs(int x, int y) {

		if (x > N || y > N) {
			return;
		}

		if (array[x][y] == 0) {
			count++;
			return;
		}

		int step = array[x][y];

		dfs(x + step, y);
		dfs(x, y + step);
	}
}
