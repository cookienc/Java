package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeSet;

/**
 * 출처: https://www.acmicpc.net/problem/2800
 */
public class Problem2800 {

	private static char[] arr;
	private static int[] match;
	private static int N;
	private static TreeSet<String> tree;
	private static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String op = br.readLine();
		arr = op.toCharArray();
		N = arr.length;
		match = new int[N];
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			if (arr[i] == '(') {
				match[i] = cnt++;
			}

			if (arr[i] == ')') {
				match[i] = --cnt;
			}
		}

		isVisited = new boolean[N];
		tree = new TreeSet<>();

		dfs(0, 0, 0, new Stack<>(), "");
		tree.remove(op);
		for (String s : tree) {
			System.out.println(s);
		}
	}

	private static void dfs(int idx, int open, int close, Stack<Integer> info, String str) {
		if (idx == N) {
			tree.add(str);
			return;
		}

		if (idx > N || open < close) {
			return;
		}

		int next = idx + 1;
		char c = arr[idx];

		if (c == '(') {
			Stack<Integer> stack = (Stack<Integer>) info.clone();
			stack.push(match[idx]);
			dfs(next, open + 1, close, stack, str + "(");
			dfs(next, open, close, info, str);
		} else if (c == ')') {
			if (open > close) {
				if (info.peek() == match[idx]) {
					Stack<Integer> stack = (Stack<Integer>) info.clone();
					stack.pop();
					dfs(next, open, close + 1, stack, str + ")");
				} else {
					dfs(next, open, close, info, str);
				}
			} else {
				dfs(next, open, close, info, str);
			}
		} else {
			dfs(next, open, close, info, str + c);
		}
	}
}
