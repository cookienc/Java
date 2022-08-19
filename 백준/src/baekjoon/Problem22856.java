package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * 출처: https://www.acmicpc.net/problem/22856
 */
public class Problem22856 {

	private static List<Node> nodes;
	private static Stack<Integer> stack;
	private static boolean[] isVisited;
	private static int count;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		nodes = new ArrayList<>();
		nodes.add(new Node(-1, -1, -1));
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes.add(new Node(a, b, c));
		}

		nodes = nodes.stream()
				.sorted(Comparator.comparingInt(Node::getData))
				.collect(Collectors.toList());

		stack = new Stack<>();
		isVisited = new boolean[N + 1];
		inOrder(1);

		dfs(1);
		System.out.println(count);
	}

	private static void dfs(int i) {
		Node cur = nodes.get(i);
		for (int j = 0; j < 2; j++) {
			int next = cur.get(j);
			if (next == -1 || isVisited[next]) {
				continue;
			}

			isVisited[next] = true;
			count++;
			dfs(next);

			if (next == stack.peek()) {
				System.out.println(count);
				System.exit(0);
			}

			count++;
			isVisited[next] = false;
		}
	}

	private static void inOrder(int i) {
		if (i == -1) {
			return;
		}

		Node cur = nodes.get(i);
		inOrder(cur.left);
		stack.push(cur.data);
		inOrder(cur.right);
	}

	private static class Node {
		int data;
		int left;
		int right;

		public Node(int data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public int get(int i) {
			return i == 0 ? left : right;
		}

		public int getData() {
			return this.data;
		}
	}
}
