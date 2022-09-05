package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 출처: https://www.acmicpc.net/problem/2800
 */
public class Problem2800 {

	private static List<Bracket> brackets = new ArrayList<>();
	private static TreeSet<String> tree;
	private static boolean[] isVisited;
	private static int N;
	private static char[] chars;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		chars = br.readLine().toCharArray();

		Stack<Integer> tmp = new Stack<>();
		N = chars.length;
		for (int i = 0; i < N; i++) {
			if (chars[i] == '(') {
				tmp.push(i);
				continue;
			}

			if (chars[i] == ')') {
				brackets.add(new Bracket(tmp.pop(), i));
			}
		}

		tree = new TreeSet<>();
		isVisited = new boolean[N];
		dfs(0);

		tree.stream().forEach(System.out::println);
	}

	private static void dfs(int depth) {
		if (depth == brackets.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				if (isVisited[i]) {
					continue;
				}
				sb.append(chars[i]);
			}

			if (sb.length() == N) {
				return;
			}

			tree.add(sb.toString());

			return;
		}

		Bracket bracket = brackets.get(depth);

		isVisited[bracket.start] = true;
		isVisited[bracket.end] = true;
		dfs(depth + 1);
		isVisited[bracket.start] = false;
		isVisited[bracket.end] = false;
		dfs(depth + 1);
	}

	private static class Bracket {
		int start;
		int end;

		public Bracket(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
