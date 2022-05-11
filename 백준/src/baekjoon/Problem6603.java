package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 출처: https://www.acmicpc.net/problem/6603
 */
public class Problem6603 {

	private static String[] choice;
	private static String[] test;
	private static boolean[] isVisited;
	private static int size;
	private static final StringBuilder sb = new StringBuilder();
	private static final int MAX = 6;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			test = br.readLine().split(" ");

			if (test[0].equals("0")) {
				break;
			}

			size = Integer.parseInt(test[0]);

			choice = new String[MAX];
			isVisited = new boolean[size];

			dfs(0, 0);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int depth, int start) {
		if (depth == MAX) {
			for (int i = 0; i < MAX; i++) {
				sb.append(choice[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < size; i++) {
			if (isVisited[i]) {
				continue;
			}

			isVisited[i] = true;
			choice[depth] = test[i + 1];
			dfs(depth + 1, i);
			isVisited[i] = false;
		}
	}
}
