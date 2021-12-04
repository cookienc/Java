package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9466 {

	private static int T;
	private static int N;
	private static int cycleMember;
	private static int array[];
	private static boolean isVisited[];
	private static boolean isDone[];

	public static void main(String[] args) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bufferedReader.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(bufferedReader.readLine());
			cycleMember = 0;
			array = new int[N + 1];
			isDone = new boolean[N + 1];
			isVisited = new boolean[N + 1];
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int n = 1; n <= N; n++) {
				array[n] = Integer.parseInt(stringTokenizer.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				if (isDone[i]) {
					continue;
				}
				dfs(i);
			}
			System.out.println(N - cycleMember);
		}
	}

	public static void dfs(int idx) {
		if (isDone[idx]) {
			return;
		}

		if (isVisited[idx]) {
			isDone[idx] = true;
			cycleMember++;
		}

		isVisited[idx] = true;
		dfs(array[idx]);
		isDone[idx] = true;
		isVisited[idx] = false;
	}
}
