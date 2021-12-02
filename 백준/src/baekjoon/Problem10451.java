package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem10451 {

	public static final String NEW_LINE = "\n";
	private static List<Integer>[] lists;
	private static boolean[] isVisited;
	private static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		StringTokenizer stringTokenizer;

		int t = Integer.parseInt(bufferedReader.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(bufferedReader.readLine());

			count = 0;
			isVisited = new boolean[n + 1];
			lists = new LinkedList[n + 1];

			for (int i = 1; i <= n; i++) {
				lists[i] = new LinkedList<>();
			}

			stringTokenizer = new StringTokenizer(bufferedReader.readLine());

			for (int i = 1; i <= n; i++) {
				int dotA = i;
				int dotB = Integer.parseInt(stringTokenizer.nextToken());

				lists[dotA].add(dotB);
			}

			for (int i = 1; i <= n; i++) {
				if (!isVisited[i]) {
					count++;
					dfs(i);
				}
			}
			stringBuilder.append(count)
					.append(NEW_LINE);
		}
		System.out.println(stringBuilder);
	}

	private static void dfs(int i) {
		if (isVisited[i]) {
			return;
		}

		isVisited[i] = true;

		for (int x : lists[i]) {
			if (!isVisited[x]) {
				dfs(x);
			}
		}
	}
}
