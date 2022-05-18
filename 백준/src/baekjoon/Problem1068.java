package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 출처: https://www.acmicpc.net/problem/1068
 */
public class Problem1068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Node[] node = new Node[N];
		for (int i = 0; i < N; i++) {
			node[i] = new Node(i);
		}

		int root = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == -1) {
				root = i;
				continue;
			}
			node[i].addParent(node[num]);
		}

		int T = Integer.parseInt(br.readLine());
		node[T].remove();

		System.out.println(node[root].leaves());

	}

	private static class Node {
		Node parent;
		List<Node> child = new ArrayList<>();
		int index;

		public Node(int index) {
			this.parent = null;
			this.index = index;
		}

		public void addParent(Node parent) {
			this.parent = parent;
			parent.child.add(this);
		}

		public int leaves() {
			int number = 0;

			if (child.size() == 0) {
				return 1;
			}

			for (Node c : child) {
				number += c.leaves();
			}

			return number;
		}

		public void remove() {
			if (this.parent == null) {
				System.out.println(0);
				System.exit(0);
			}
			this.parent.child.remove(this);
			this.parent = null;
		}
	}
}
