package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9466 {

	static int n;
	static int[] arr;
	static int count = 0;
	static boolean[] visited;
	static boolean[] finished;

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;

		int tc = Integer.parseInt(bufferedReader.readLine());

		for (int t = 0; t < tc; t++) {
			n = Integer.parseInt(bufferedReader.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			count = 0;

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int i = 1; i < n + 1; i++) {
				arr[i] = Integer.parseInt(stringTokenizer.nextToken());
			}

			for (int i = 1; i < n + 1; i++) {
				dfs(i);
			}

			System.out.println(n - count);
		}
	}

	static void dfs(int now) {
		if (visited[now]) {
			return;
		}

		visited[now] = true;
		int next = arr[now];

		if (visited[next] != true) {
			dfs(next);
		}

		if (finished[next] != true) {
			count++;
			for (int i = next; i != now; i = arr[i]) { //싸이클 찾기
				finished[i] = true;
				count++;
			}
		}
		finished[now] = true;
	}
}
